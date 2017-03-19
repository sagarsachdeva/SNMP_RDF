package edu.tcd.nds.ntwmgmt.agent;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import edu.tcd.nds.ntwmgmt.infobase.HostResourcesMib;
import org.snmp4j.agent.DuplicateRegistrationException;

import edu.tcd.nds.ntwmgmt.infobase.AgentInfo;
import edu.tcd.nds.ntwmgmt.infobase.DbInfo;
import org.snmp4j.agent.mo.DefaultMOFactory;

public class AgentStartup {

	static AgentInfo agentInfo;

	static DbInfo dbInfo;

	static HostResourcesMib hrInfo;

	public static void main(String[] args)
			throws IOException, InterruptedException, NumberFormatException, DuplicateRegistrationException {
		if (args.length != 2) {
			System.out.println("Please provide Ip address and port as arguments");
			System.exit(1);
		}
		String ipAddress = args[0];
		String port = args[1];

		SNMPAgent agent = new SNMPAgent(ipAddress + "/" + port);
		agent.start();

		registerAgentInfo(Integer.parseInt(port), agent);
		registerDbInfo(agent);
		registerHrInfo(agent);

		System.out.println("Agent started");
		while (true) {
			Thread.sleep(3000);
			updateManagerObject(agent);
		}

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
		hrInfo.registerMOs(agent.getServer(),agent.getDefaultContext());
	}
}