package com.autoqa.framework.apitest.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TestUtils {

	public static String getValueJPath(JSONObject responseJson, String jPath) throws JSONException {
		Object obj = responseJson;
		for (String s : jPath.split("/"))
			if (!s.isEmpty())
				if (!(s.contains("[") || s.contains("]")))
					obj = ((JSONObject) obj).get(s);
				else if (s.contains("[") || s.contains("]"))
					obj = ((JSONArray) ((JSONObject) obj).get(s.split("\\[")[0]))
							.get(Integer.parseInt(s.split("\\[")[1].replace("]", "")));
		
		return obj.toString();

		// My own unsuccessful solution
		// if (responseJson == null || jPath == null || jPath == "")
		// return null;
		//
		// else if (jPath.contains(".")){
		// String[] jNodes = jPath.split("\\.");
		// System.out.println(jNodes.length);
		// JSONObject data = responseJson.getJSONObject(jNodes[0]);
		// String jValue = data.getString(jNodes[1]);
		//// responseJson.keys()
		//// for (int i=0; i < jNodes.length; i++) {
		//// JSONObject jNodeObjects = responseJson.getJSONObject(jNodes[i]);
		//// }
		// return jValue;
		// }
		//
		// return responseJson.getString(jPath);
	}
}
