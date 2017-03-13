package edu.tcd.nds.ntwmgmt.utils;

import org.snmp4j.smi.OID;

public class ObjectIdentifiers {

	public static final OID AGENT_SYSDESC_IDENTIFIER = new OID(".1.3.6.1.2.1.1.1.0");
	
	public static final OID BASE_AGENT_INFO_IDENTIFIER = new OID(".1.3.6.1.2.1.2");
	public static final OID AGENT_IP_IDENTIFIER = new OID(".1.3.6.1.2.1.2.1.1");
	public static final OID AGENT_PORT_IDENTIFIER = new OID(".1.3.6.1.2.1.2.2.1");
	public static final OID AGENT_START_TIME_IDENTIFIER = new OID(".1.3.6.1.2.1.2.3.1");

	public static final OID BASE_DB_INFO_IDENTIFIER = new OID(".1.3.7.1.2.1.2");
	public static final OID DB_IP_IDENTIFIER = new OID(".1.3.7.1.2.1.2.1.1");
	public static final OID DB_PORT_IDENTIFIER = new OID(".1.3.7.1.2.1.2.2.1");
	public static final OID DB_NAME_IDENTIFIER = new OID(".1.3.7.1.2.1.2.3.1");
	public static final OID DB_VERSION_IDENTIFIER = new OID(".1.3.7.1.2.1.2.4.1");
	public static final OID DB_UPTIME_IDENTIFIER = new OID(".1.3.7.1.2.1.2.5.1");
	public static final OID DB_START_TIME_IDENTIFIER = new OID(".1.3.7.1.2.1.2.6.1");
	public static final OID DB_STATUS_IDENTIFIER = new OID(".1.3.7.1.2.1.2.7.1");
}
