package edu.tcd.nds.ntwmgmt.manager;

import java.io.IOException;

import org.snmp4j.CommandResponder;
import org.snmp4j.CommandResponderEvent;
import org.snmp4j.CommunityTarget;
import org.snmp4j.MessageDispatcher;
import org.snmp4j.MessageDispatcherImpl;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.mp.MPv1;
import org.snmp4j.mp.MPv2c;
import org.snmp4j.security.Priv3DES;
import org.snmp4j.security.SecurityProtocols;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.TcpAddress;
import org.snmp4j.smi.TransportIpAddress;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.AbstractTransportMapping;
import org.snmp4j.transport.DefaultTcpTransportMapping;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.MultiThreadedMessageDispatcher;
import org.snmp4j.util.ThreadPool;

import edu.tcd.nds.ntwmgmt.utils.ObjectIdentifiers;

public class TrapReceiver implements CommandResponder {

	public synchronized void listen(TransportIpAddress address) throws IOException {
		AbstractTransportMapping transport;

		if (address instanceof TcpAddress) {
			transport = new DefaultTcpTransportMapping((TcpAddress) address);
		} else {
			transport = new DefaultUdpTransportMapping((UdpAddress) address, true);
		}

		ThreadPool threadPool = ThreadPool.create("DispatcherPool", 10);
		MessageDispatcher mDispathcher = new MultiThreadedMessageDispatcher(threadPool, new MessageDispatcherImpl());

		// add message processing models
		mDispathcher.addMessageProcessingModel(new MPv1());
		mDispathcher.addMessageProcessingModel(new MPv2c());

		// add all security protocols
		SecurityProtocols.getInstance().addDefaultProtocols();
		SecurityProtocols.getInstance().addPrivacyProtocol(new Priv3DES());

		// Create Target
		CommunityTarget target = new CommunityTarget();
		target.setCommunity(new OctetString("public"));

		Snmp snmp = new Snmp(mDispathcher, transport);
		snmp.addCommandResponder(this);

		transport.listen();
		// System.out.println("Listening on " + address);

	}

	/**
	 * This method will be called whenever a pdu is received on the given port
	 * specified in the listen() method
	 */
	public synchronized void processPdu(CommandResponderEvent cmdRespEvent) {
		// System.out.println("Received PDU...");
		PDU pdu = cmdRespEvent.getPDU();
		if (pdu != null) {
			System.out.println("------------------NOTIFICATION--------------------");
			System.out.println(pdu.getErrorStatus());
			if (pdu.getErrorStatus() == 1) {
				System.out.println("System Online for: " + pdu.getVariableBindings().get(2) + " seconds");
				System.out.println("Recorded on:" + pdu.getVariableBindings().get(0).toString().split("=")[1]);
			}else if(pdu.getType() == PDU.NOTIFICATION){
				System.out.println("State changed: " + pdu.getVariableBindings().get(2));
				System.out.println("At:" + pdu.getVariableBindings().get(0).toString().split("=")[1]);
			}
		}
	}
}