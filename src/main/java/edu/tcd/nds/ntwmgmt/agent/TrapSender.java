package edu.tcd.nds.ntwmgmt.agent;

import java.util.Date;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.IpAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

public class TrapSender {

	public static final String community = "public";

	// Sending Trap for sysLocation of RFC1213
	public static final OID Oid = new OID(".1.3.7.1.2.1.2.7.1");

	// IP of Local Host
	public static final String ipAddress = "127.0.0.1";

	// Ideally Port 162 should be used to send receive Trap, any other available
	// Port can be used
	public static final int port = 162;
	
	UdpAddress adr = new UdpAddress(ipAddress + "/" + port);
	/**
	 * This methods sends the V1 trap to the Localhost in port 162
	 */
	public void sendTrap_Version2(String status) {
		try {
			// Create Transport Mapping
			TransportMapping transport = new DefaultUdpTransportMapping();
			transport.listen();

			// Create Target
			CommunityTarget cTarget = new CommunityTarget();
			cTarget.setCommunity(new OctetString(community));
			cTarget.setVersion(SnmpConstants.version2c);
			cTarget.setAddress(adr);
			cTarget.setRetries(2);
			cTarget.setTimeout(5000);

			// Create PDU for V2
			PDU pdu = new PDU();

			// need to specify the system up time
			pdu.add(new VariableBinding(SnmpConstants.sysUpTime, new OctetString(new Date().toString())));
			pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID, Oid));
//			pdu.add(new VariableBinding(SnmpConstants.snmpTrapAddress, new IpAddress(ipAddress)));
//
			pdu.add(new VariableBinding(Oid, new OctetString(status)));
			pdu.setType(PDU.NOTIFICATION);
			

			// Send the PDU
			Snmp snmp = new Snmp(transport);
			System.out.println("Sending V2 Trap... Check Wheather NMS is Listening or not? ");
			snmp.send(pdu, cTarget);
			snmp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}