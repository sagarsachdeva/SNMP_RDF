package edu.tcd.nds.ntwmgmt.infobase;

import java.util.ArrayList;
import java.util.List;

import org.snmp4j.agent.BaseAgent;
import org.snmp4j.agent.DuplicateRegistrationException;
import org.snmp4j.agent.mo.MOAccessImpl;
import org.snmp4j.smi.Integer32;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.SMIConstants;
import org.snmp4j.smi.Variable;

import edu.tcd.nds.ntwmgmt.agent.MOTableBuilder;
import edu.tcd.nds.ntwmgmt.utils.ObjectIdentifiers;

public class DbInfo implements BaseInterface {

	private String ipAddress;

	private int port;

	private List<String> dbNames = new ArrayList<String>();

	private String version;

	private int upTime;

	private String startDateTime;

	private String status;

	private MOTableBuilder builder;

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getDbNames() {
		StringBuilder sb = new StringBuilder();
		String prefix = "";
		for (String n : dbNames) {
			sb.append(prefix);
			prefix = ", ";
			sb.append(n);
		}
		return sb.toString();
	}

	public void setDbName(List<String> dbNames) {
		this.dbNames = dbNames;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getUpTime() {
		return upTime;
	}

	public void setUpTime(int upTime) {
		this.upTime = upTime;
	}

	public String getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		this.startDateTime = startDateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public void registerManagedObject(BaseAgent agent) throws DuplicateRegistrationException {
		builder = new MOTableBuilder(ObjectIdentifiers.BASE_DB_INFO_IDENTIFIER)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_INTEGER, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_INTEGER32, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addColumnType(SMIConstants.SYNTAX_OCTET_STRING, MOAccessImpl.ACCESS_READ_WRITE)
				.addRowValue(new OctetString(this.ipAddress)).addRowValue(new Integer32(this.port))
				.addRowValue(new OctetString(getDbNames())).addRowValue(new OctetString(this.version))
				.addRowValue(new Integer32(this.upTime)).addRowValue(new OctetString(this.startDateTime))
				.addRowValue(new OctetString(this.status));

		agent.getServer().register(builder.build(), null);
		
	}

	public void updateManagerObject(BaseAgent agent) throws DuplicateRegistrationException {
		Variable[] rowElements = builder.getTableRows().get(0);
		rowElements[0] = new OctetString(this.ipAddress);
		rowElements[1] = new Integer32(this.port);
		rowElements[2] = new OctetString(getDbNames());
		rowElements[3] = new OctetString(this.version);
		rowElements[4] = new Integer32(this.upTime);
		rowElements[5] = new OctetString(this.startDateTime);
		rowElements[6] = new OctetString(this.status);
	}

}
