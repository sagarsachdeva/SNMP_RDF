package edu.tcd.nds.ntwmgmt.agent;

import java.io.IOException;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

import edu.tcd.nds.ntwmgmt.utils.ObjectIdentifiers;

public class TrapThread extends Thread {

	public static String lastStatus = "";

	public void run() {
		try {
			TrapSender trapV2 = new TrapSender();
			lastStatus = getTrapStatus().getResponse().get(0).getVariable().toString();
			while (true) {

				ResponseEvent event = getTrapStatus();
				if (getStatusChange2(event)) {
					trapV2.sendTrap_Version2(event, 1);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static boolean getStatusChange2(ResponseEvent event) throws IOException {
		String value = event.getResponse().get(0).getVariable().toString();
		if (value.equals(lastStatus)) {
			lastStatus = value;
			return false;
		}
		lastStatus = value;
		return true;
	}

	private static boolean getStatusChange() throws IOException {
		String value = getTrapStatus().getResponse().get(0).getVariable().toString();
		if (value.equals(lastStatus)) {
			lastStatus = value;
			return false;
		}
		lastStatus = value;
		return true;
	}

	private static ResponseEvent getTrapStatus() throws IOException {
		TransportMapping transport = new DefaultUdpTransportMapping();
		transport.listen();
		Snmp snmp = new Snmp(transport);
		Address targetAddress = GenericAddress.parse("udp:127.0.0.1/2001");
		CommunityTarget target = new CommunityTarget();
		target.setCommunity(new OctetString("public"));
		target.setAddress(targetAddress);
		target.setRetries(2);
		target.setTimeout(1500);
		target.setVersion(SnmpConstants.version2c);
		PDU pdu = new PDU();
		pdu.add(new VariableBinding(ObjectIdentifiers.DB_STATUS_IDENTIFIER));
		pdu.add(new VariableBinding(ObjectIdentifiers.DB_UPTIME_IDENTIFIER));
		pdu.setType(PDU.GET);
		ResponseEvent event = snmp.send(pdu, target, null);

		return event;
	}

}
