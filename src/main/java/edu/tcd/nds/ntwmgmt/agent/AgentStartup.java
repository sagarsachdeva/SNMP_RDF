package edu.tcd.nds.ntwmgmt.agent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.apache.jena.query.DatasetAccessor;
import org.apache.jena.query.DatasetAccessorFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.agent.mo.DefaultMOFactory;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import edu.tcd.nds.ntwmgmt.infobase.AgentInfo;
import edu.tcd.nds.ntwmgmt.infobase.DbInfo;
import edu.tcd.nds.ntwmgmt.infobase.HostResourcesMib;
import edu.tcd.nds.ntwmgmt.utils.Constants;
import edu.tcd.nds.ntwmgmt.utils.ObjectIdentifiers;

public class AgentStartup {

	static AgentInfo agentInfo;

	static DbInfo dbInfo;

	static HostResourcesMib hrInfo;

	public static String lastStatus = "";

	public static void main(String[] args)
			throws IOException, InterruptedException, NumberFormatException, DuplicateRegistrationException {
		if (args.length != 2) {
			System.out.println("Please provide Ip address and port as arguments");
			System.exit(1);
		}
		loadDBData();

		String ipAddress = args[0];
		String port = args[1];

		SNMPAgent agent = new SNMPAgent(ipAddress + "/" + port);
		agent.start();

		registerAgentInfo(Integer.parseInt(port), agent);
		registerDbInfo(agent);
		registerHrInfo(agent);
		TrapSender trapV2 = new TrapSender();

		System.out.println("Agent started");
		while (true) {
			if (getStatusChange()) {
				trapV2.sendTrap_Version2(getTrapStatus());
			}
			Thread.sleep(1000);
			updateManagerObject(agent);
		}

	}

	private static boolean getStatusChange() throws IOException {
		if (getTrapStatus().equals(lastStatus)) {
			lastStatus = getTrapStatus();
			return false;
		}
		lastStatus = getTrapStatus();
		return true;
	}

	private static String getTrapStatus() throws IOException {
		Snmp snmp;
		TransportMapping transport = new DefaultUdpTransportMapping();
		snmp = new Snmp(transport);
		transport.listen();
		Address targetAddress = GenericAddress.parse("udp:127.0.0.1/2001");
		CommunityTarget target = new CommunityTarget();
		target.setCommunity(new OctetString("public"));
		target.setAddress(targetAddress);
		target.setRetries(2);
		target.setTimeout(1500);
		target.setVersion(SnmpConstants.version2c);
		PDU pdu = new PDU();
		pdu.add(new VariableBinding(ObjectIdentifiers.DB_STATUS_IDENTIFIER));
		pdu.setType(PDU.GET);
		ResponseEvent event = snmp.send(pdu, target, null);

		return event.getResponse().get(0).getVariable().toString();
	}

	private static void loadDBData() throws FileNotFoundException {
		DatasetAccessor accessor;
		accessor = DatasetAccessorFactory.createHTTP(Constants.STORE_DATA_URL);

		InputStream in = new FileInputStream(Constants.RDF_DATA);
		;
		Model m = ModelFactory.createDefaultModel();
		m.read(in, "", "RDF/XML");

		accessor.putModel(m);
	}

	private static void updateManagerObject(SNMPAgent agent)
			throws UnknownHostException, DuplicateRegistrationException {
		StoreInfoFetcher.fetchStoreDetails(dbInfo);
		dbInfo.updateManagerObject(agent);

	}

	private static void registerDbInfo(SNMPAgent agent) throws UnknownHostException, DuplicateRegistrationException {
		dbInfo = new DbInfo();
		StoreInfoFetcher.fetchStoreDetails(dbInfo);
		dbInfo.registerManagerObject(agent);

	}

	private static void registerAgentInfo(int port, SNMPAgent agent)
			throws UnknownHostException, DuplicateRegistrationException {
		agentInfo = new AgentInfo();
		agentInfo.setIpAddress(InetAddress.getLocalHost().getHostAddress());
		agentInfo.setPort(port);
		agentInfo.setStartupTime(new Date());
		agentInfo.registerManagerObject(agent);
	}

	private static void registerHrInfo(SNMPAgent agent) throws DuplicateRegistrationException {
		hrInfo = new HostResourcesMib(DefaultMOFactory.getInstance());
		hrInfo.registerMOs(agent.getServer(), agent.getDefaultContext());
	}
}
