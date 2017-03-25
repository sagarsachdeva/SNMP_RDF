package edu.tcd.nds.ntwmgmt.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.tcd.nds.ntwmgmt.utils.Constants;
import edu.tcd.nds.ntwmgmt.utils.ObjectIdentifiers;

public class ManagerCLI {
	public static void main(String[] args) throws InterruptedException, IOException {
		List<SNMPManager> managerEndpoints = new ArrayList<SNMPManager>();

		for (String endpoint : Constants.agentEndpoints) {
			managerEndpoints.add(new SNMPManager(endpoint));
		}

		Scanner reader = new Scanner(System.in);
		boolean isExit = false;
		while (!isExit) {
			System.out.println("Please select one of the following options:");
			System.out.println("Press 1 to get all agents");
			System.out.println("Press 2 followed by agent id to get agent information");
			System.out.println("Press 3 followed by agent id to get agent's datastore information");
			System.out.println("Press 4 to exit");
			int option = reader.nextInt();
			switch (option) {
			case 1:
				int id = 1;
				for (String endpoint : Constants.agentEndpoints) {
					System.out.println("id " + id + ": " + endpoint);
					id++;
				}
				System.out.println();
				break;

			case 2:
				System.out.println("Please give the agent id");
				int agentId = reader.nextInt();

				if (agentId > managerEndpoints.size()) {
					System.out.println("--------Wrong agent selected------------");
					break;
				}

				SNMPManager manager = managerEndpoints.get(agentId - 1);
				System.out.println("AgentInfo");
				System.out.println("Agent IP Address : " + manager.getAsString(ObjectIdentifiers.AGENT_IP_IDENTIFIER));
				System.out.println("Agent Port : " + manager.getAsString(ObjectIdentifiers.AGENT_PORT_IDENTIFIER));
				System.out.println(
						"Startup Time : " + manager.getAsString(ObjectIdentifiers.AGENT_START_TIME_IDENTIFIER));
				System.out.println(
						"CPU usage : " + manager.getAsString(ObjectIdentifiers.AGENT_CPU_USAGE_IDENTIFIER) + "%");
				System.out.println("Memory Usage : "
						+ manager.getAsString(ObjectIdentifiers.AGENT_MEMORY_USAGE_IDENTIFIER) + " MB");

				System.out.println();
				break;

			case 3:
				System.out.println("Please give the agent id");
				int aId = reader.nextInt();

				if (aId > managerEndpoints.size()) {
					System.out.println("--------Wrong agent selected------------");
					break;
				}

				SNMPManager m = managerEndpoints.get(aId - 1);
				System.out.println("Agent Data Store Info");
				System.out.println("Status : " + m.getAsString(ObjectIdentifiers.DB_STATUS_IDENTIFIER));
				System.out.println("IP Address : " + m.getAsString(ObjectIdentifiers.DB_IP_IDENTIFIER));
				System.out.println("Port : " + m.getAsString(ObjectIdentifiers.DB_PORT_IDENTIFIER));
				System.out.println("Name : " + m.getAsString(ObjectIdentifiers.DB_NAME_IDENTIFIER));
				System.out.println("Version : " + m.getAsString(ObjectIdentifiers.DB_VERSION_IDENTIFIER));
				System.out.println("UpTime : " + m.getAsString(ObjectIdentifiers.DB_UPTIME_IDENTIFIER));
				System.out.println("Startup Time : " + m.getAsString(ObjectIdentifiers.DB_START_TIME_IDENTIFIER));

				System.out.println();
				break;

			case 4:
				System.out.println("Exiting");
				isExit = true;
				break;

			default:
				System.out.println("-----------Wrong Choice-------------");
				break;
			}

		}
		reader.close();
	}

}
