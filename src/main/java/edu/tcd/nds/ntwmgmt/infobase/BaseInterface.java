package edu.tcd.nds.ntwmgmt.infobase;

import org.snmp4j.agent.BaseAgent;
import org.snmp4j.agent.DuplicateRegistrationException;

public interface BaseInterface {

	public void registerManagerObject(BaseAgent agent) throws DuplicateRegistrationException;
}
