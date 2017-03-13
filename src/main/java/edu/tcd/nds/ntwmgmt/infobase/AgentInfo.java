package edu.tcd.nds.ntwmgmt.infobase;

import java.util.Date;

import org.snmp4j.agent.BaseAgent;
import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.SMIConstants;

import edu.tcd.nds.ntwmgmt.agent.MOTableBuilder;
import edu.tcd.nds.ntwmgmt.utils.Constants;
import edu.tcd.nds.ntwmgmt.utils.ObjectIdentifiers;

public class AgentInfo implements BaseInterface {

	private String ipAddress;

	private Date startupTime;

	private int port;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public Date getStartupTime() {
		return startupTime;
	}

	public void setStartupTime(Date startupTime) {
		this.startupTime = startupTime;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public void registerManagerObject(BaseAgent agent) throws DuplicateRegistrationException {
		MOTableBuilder builder = new MOTableBuilder(ObjectIdentifiers.BASE_AGENT_INFO_IDENTIFIER)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_INTEGER, MOAccessImpl.ACCESS_READ_WRITE)
				.addRowValue(new OctetString(this.ipAddress))
				.addRowValue(new OctetString(Constants.DATE_FORMATTER.format(this.startupTime)))
				.addRowValue(new Integer32(this.port));

		agent.getServer().register(builder.build(), null);
	}

}
