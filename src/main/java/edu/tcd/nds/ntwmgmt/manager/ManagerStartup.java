package edu.tcd.nds.ntwmgmt.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.tcd.nds.ntwmgmt.infobase.HostResourcesMib;
import edu.tcd.nds.ntwmgmt.utils.Constants;
import edu.tcd.nds.ntwmgmt.utils.ObjectIdentifiers;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.UdpAddress;

public class ManagerStartup {

	public static void main(String[] args) throws InterruptedException, IOException {
		List<SNMPManager> managerEndpoints = new ArrayList<SNMPManager>();

		for (String endpoint : Constants.agentEndpoints) {
			managerEndpoints.add(new SNMPManager(endpoint));
		}
		
		TrapReceiver snmp4jTrapReceiver = new TrapReceiver();
		UdpAddress trapAdr = new UdpAddress("localhost/1337");
	

		while (true) {
			for (SNMPManager manager : managerEndpoints) {
				
				
				System.out.println("------------------Agent--------------------");

				System.out.println();
				// Printing Agent Info
				System.out.println("AgentInfo");
				System.out.println("Agent IP Address : " + manager.getAsString(ObjectIdentifiers.AGENT_IP_IDENTIFIER));
				System.out.println("Agent Port : " + manager.getAsString(ObjectIdentifiers.AGENT_PORT_IDENTIFIER));
				System.out.println(
						"Startup Time : " + manager.getAsString(ObjectIdentifiers.AGENT_START_TIME_IDENTIFIER));

				System.out.println();

				// Printing Agent Data Store Info
				System.out.println("Agent Data Store Info");
				System.out.println("Status : " + manager.getAsString(ObjectIdentifiers.DB_STATUS_IDENTIFIER));
				System.out.println("IP Address : " + manager.getAsString(ObjectIdentifiers.DB_IP_IDENTIFIER));
				System.out.println("Port : " + manager.getAsString(ObjectIdentifiers.DB_PORT_IDENTIFIER));
				System.out.println("Name : " + manager.getAsString(ObjectIdentifiers.DB_NAME_IDENTIFIER));
				System.out.println("Version : " + manager.getAsString(ObjectIdentifiers.DB_VERSION_IDENTIFIER));
				System.out.println("UpTime : " + manager.getAsString(ObjectIdentifiers.DB_UPTIME_IDENTIFIER));
				System.out.println("Startup Time : " + manager.getAsString(ObjectIdentifiers.DB_START_TIME_IDENTIFIER));

				System.out.println("test host resource MIB : " + manager.getAsString(HostResourcesMib.oidHrSystemUptime));
				
				snmp4jTrapReceiver.listen(trapAdr);
			}
			Thread.sleep(15000);
		}
	}
}
