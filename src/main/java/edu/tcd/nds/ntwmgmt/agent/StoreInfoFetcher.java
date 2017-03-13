package edu.tcd.nds.ntwmgmt.agent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import edu.tcd.nds.ntwmgmt.infobase.DbInfo;
import edu.tcd.nds.ntwmgmt.utils.Constants;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

public class StoreInfoFetcher {

	public static void fetchStoreDetails(DbInfo dbInfo) throws UnknownHostException {
		dbInfo.setIpAddress(InetAddress.getLocalHost().getHostAddress());
		dbInfo.setPort(Constants.DB_PORT);
		dbInfo.setDbName("-");

		String response = "";
		try {
			response = getResponseString();
		} catch (Exception e) {
			dbInfo.setStatus("DOWN");
			dbInfo.setVersion("-");
			dbInfo.setStartDateTime("-");
			dbInfo.setUpTime(0);
			return;
		}

		JSONObject json = (JSONObject) JSONSerializer.toJSON(response);

		dbInfo.setStatus("UP");
		dbInfo.setVersion(json.getString("version"));
		dbInfo.setStartDateTime(json.getString("startDateTime"));
		dbInfo.setUpTime(json.getInt("uptime"));
		return;
	}

	private static String getResponseString() throws IOException {
		StringBuilder response = new StringBuilder();
		try {
			URL urlObject = new URL(Constants.STORE_INFO_URL);
			HttpURLConnection con = (HttpURLConnection) urlObject.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return response.toString();
	}
}
