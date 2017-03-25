package edu.tcd.nds.ntwmgmt.agent;

import java.util.Date;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import edu.tcd.nds.ntwmgmt.utils.ObjectIdentifiers;

public class TrapSender {

	public static final String community = "public";

	//
	// IP of Local Host
	public static final String ipAddress = "127.0.0.1";

	public static final int port = 1337;

	UdpAddress adr = new UdpAddress(ipAddress + "/" + port);

	public void sendTrap_Version2(ResponseEvent status, int trapcode) {
		try {
//			// Create Transport Mapping
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

			// pdu.add(new VariableBinding(SnmpConstants.snmpTrapAddress, new
			// IpAddress(ipAddress)));
			//
			if (trapcode == 1) {
				pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID, ObjectIdentifiers.DB_STATUS_IDENTIFIER));
				pdu.add(new VariableBinding(ObjectIdentifiers.DB_STATUS_IDENTIFIER,
						new OctetString(status.getResponse().get(0).getVariable().toString())));
				pdu.setType(PDU.NOTIFICATION);
			} else {
				pdu.add(new VariableBinding(SnmpConstants.snmpTrapOID, ObjectIdentifiers.DB_UPTIME_IDENTIFIER));
				pdu.add(new VariableBinding(ObjectIdentifiers.DB_UPTIME_IDENTIFIER,
						new OctetString(status.getResponse().get(1).getVariable().toString())));
				pdu.setErrorStatus(1);
				pdu.setType(PDU.NOTIFICATION);

			}

			// Send the PDU
			Snmp snmp = new Snmp(transport);
			snmp.send(pdu, cTarget);
			snmp.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}