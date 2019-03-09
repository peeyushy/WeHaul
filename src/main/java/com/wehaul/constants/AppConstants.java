package com.wehaul.constants;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AppConstants implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Map<java.lang.String, java.lang.String> clientTypeMap = new HashMap<String, String>();

	private static final Map<java.lang.String, java.lang.String> cityMap = new HashMap<String, String>();

	private static final Map<java.lang.String, java.lang.String> reqTypeMap = new HashMap<String, String>();

	public static Map<String, String> getClientType() {
		// Admin role not available from UI
		clientTypeMap.put("A", "Admin");
		clientTypeMap.put("T", "Transporter");
		clientTypeMap.put("S", "Supplier");
		clientTypeMap.put("B", "Broker");
		return clientTypeMap;
	}

	public static Map<String, String> getCityMap() {
		cityMap.put("Delhi", "Delhi (NCR)");
		cityMap.put("Bangalore", "Bangalore");
		cityMap.put("Chennai", "Chennai");
		cityMap.put("Hyderabad", "Hyderabad");
		cityMap.put("Kolkata", "Kolkata");
		cityMap.put("Mumbai", "Mumbai");
		return cityMap;
	}

	public static Map<String, String> getReqTypeMap() {
		reqTypeMap.put("Load", "Load");
		reqTypeMap.put("Vehicle", "Vehicle");
		return reqTypeMap;
	}

	public enum RoleNames {
		ADMIN, TWOWAY, TRANSPORTER, SUPPLER
	};

}
