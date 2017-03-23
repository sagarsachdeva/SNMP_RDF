package edu.tcd.nds.ntwmgmt.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Constants {

	public static final DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	public static final int DB_PORT = 3030;

	public static final String STORE_INFO_URL = "http://localhost:3030/$/server";
	
	public static final String STORE_DATA_URL = "http://localhost:3030/ds/data";
	
	public static final String RDF_DATA = "src/main/java/edu/tcd/nds/ntwmgmt/utils/pizza.rdf";

	public static String[] agentEndpoints = { "udp:127.0.0.1/2001" };
}
