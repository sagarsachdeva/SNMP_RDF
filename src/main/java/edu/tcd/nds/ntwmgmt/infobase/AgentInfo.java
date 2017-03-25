package edu.tcd.nds.ntwmgmt.infobase;

import java.util.Date;

import org.snmp4j.agent.BaseAgent;
import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.SMIConstants;
import org.snmp4j.smi.Variable;

import edu.tcd.nds.ntwmgmt.agent.MOTableBuilder;
import edu.tcd.nds.ntwmgmt.utils.Constants;
import edu.tcd.nds.ntwmgmt.utils.ObjectIdentifiers;

public class AgentInfo implements BaseInterface {

	private String ipAddress;

	private Date startupTime;

	private int port;

	private Double cpuUtilization;

	private Double memoryUtilization;

	private MOTableBuilder builder;

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

	public double getCpuUtilization() {
		return cpuUtilization;
	}

	public void setCpuUtilization(double cpuUtilization) {
		this.cpuUtilization = cpuUtilization;
	}

	public double getMemoryUtilization() {
		return memoryUtilization;
	}

	public void setMemoryUtilization(double memoryUtilization) {
		this.memoryUtilization = memoryUtilization;
	}

	@Override
	public void registerManagedObject(BaseAgent agent) throws DuplicateRegistrationException {
		builder = new MOTableBuilder(ObjectIdentifiers.BASE_AGENT_INFO_IDENTIFIER)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_INTEGER, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addRowValue(new OctetString(this.ipAddress)).addRowValue(new Integer32(this.port))
				.addRowValue(new OctetString(Constants.DATE_FORMATTER.format(this.startupTime)))
				.addRowValue(new OctetString((this.cpuUtilization).toString()))
				.addRowValue(new OctetString((this.memoryUtilization).toString()));

		agent.getServer().register(builder.build(), null);
	}

	public void updateManagedObject(BaseAgent agent) throws DuplicateRegistrationException {
		Variable[] rowElements = builder.getTableRows().get(0);
		rowElements[3] = new OctetString((this.cpuUtilization).toString());
		rowElements[4] = new OctetString((this.memoryUtilization).toString());
	}
}
