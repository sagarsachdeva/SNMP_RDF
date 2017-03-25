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
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.agent.DuplicateRegistrationException;

import edu.tcd.nds.ntwmgmt.infobase.AgentInfo;
import edu.tcd.nds.ntwmgmt.infobase.DbInfo;
import edu.tcd.nds.ntwmgmt.infobase.HostResourcesMib;
import edu.tcd.nds.ntwmgmt.utils.Constants;

public class AgentStartup {

	static AgentInfo agentInfo;

	static DbInfo dbInfo;

	static HostResourcesMib hrInfo;

	public static String lastStatus = "";

	static Snmp snmp;

	static TransportMapping transport;

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
		TrapThread thread = new TrapThread();
		thread.start();
		// TrapSender trapV2 = new TrapSender();

		System.out.println("Agent started");
		while (true) {
			Thread.sleep(1000);
			updateManagedObject(agent);

			// if (getStatusChange()) {
			// trapV2.sendTrap_Version2(getTrapStatus(), 1);
			// }
			// else if
			// (getTrapStatus().getResponse().get(1).getVariable().toInt() % 20
			// == 0
			// && getTrapStatus().getResponse().get(1).getVariable().toInt() !=
			// 0) {
			// trapV2.sendTrap_Version2(getTrapStatus(), 0);
			// }
		}

	}

	// private static boolean getStatusChange() throws IOException {
	// String value =
	// getTrapStatus().getResponse().get(0).getVariable().toString();
	// if (value.equals(lastStatus)) {
	// lastStatus = value;
	// return false;
	// }
	// lastStatus = value;
	// return true;
	// }
	//
	// private static ResponseEvent getTrapStatus() throws IOException {
	// TransportMapping transport = new DefaultUdpTransportMapping();
	// transport.listen();
	// Snmp snmp = new Snmp(transport);
	// Address targetAddress = GenericAddress.parse("udp:127.0.0.1/2001");
	// CommunityTarget target = new CommunityTarget();
	// target.setCommunity(new OctetString("public"));
	// target.setAddress(targetAddress);
	// target.setRetries(2);
	// target.setTimeout(1500);
	// target.setVersion(SnmpConstants.version2c);
	// PDU pdu = new PDU();
	// pdu.add(new VariableBinding(ObjectIdentifiers.DB_STATUS_IDENTIFIER));
	// pdu.add(new VariableBinding(ObjectIdentifiers.DB_UPTIME_IDENTIFIER));
	// pdu.setType(PDU.GET);
	// ResponseEvent event = snmp.send(pdu, target, null);
	//
	// return event;
	// }

	private static void loadDBData() throws FileNotFoundException {
		try {
			DatasetAccessor accessor;
			accessor = DatasetAccessorFactory.createHTTP(Constants.STORE_DATA_URL);

			InputStream in = new FileInputStream(Constants.RDF_DATA);
			;
			Model m = ModelFactory.createDefaultModel();
			m.read(in, "", "RDF/XML");

			accessor.putModel(m);
		} catch (Exception e) {
		}
	}

	private static void updateManagedObject(SNMPAgent agent)
			throws UnknownHostException, DuplicateRegistrationException {
		StoreInfoFetcher.fetchStoreDetails(dbInfo);
		StoreInfoFetcher.updateMemoryAndCPU(agentInfo);
		dbInfo.updateManagerObject(agent);
		agentInfo.updateManagedObject(agent);

	}

	private static void registerDbInfo(SNMPAgent agent) throws UnknownHostException, DuplicateRegistrationException {
		dbInfo = new DbInfo();
		StoreInfoFetcher.fetchStoreDetails(dbInfo);
		dbInfo.registerManagedObject(agent);

	}

	private static void registerAgentInfo(int port, SNMPAgent agent)
			throws UnknownHostException, DuplicateRegistrationException {
		agentInfo = new AgentInfo();
		agentInfo.setIpAddress(InetAddress.getLocalHost().getHostAddress());
		agentInfo.setPort(port);
		agentInfo.setStartupTime(new Date());
		agentInfo.setCpuUtilization(0.0);
		agentInfo.setMemoryUtilization(0.0);
		agentInfo.registerManagedObject(agent);
	}
}
