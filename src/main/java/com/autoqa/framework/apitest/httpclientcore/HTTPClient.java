package com.autoqa.framework.apitest.httpclientcore;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class HTTPClient {

	//HTTP GET call
	public static CloseableHttpResponse getCall(String url) throws ClientProtocolException, IOException, JSONException{
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet getCall = new HttpGet(url);
		CloseableHttpResponse response = httpClient.execute(getCall);
		
		return response;
//		int statusCode = response.getStatusLine().getStatusCode();
		
//		System.out.println("The status code = " + statusCode);
//		
//		//Turning HTTP reponse to a String
//		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//		
//		//Using Reponse String to create a JSON Object for extraction of specific node in the JSON
//		JSONObject responseJson = new JSONObject(responseString);
//		System.out.println("\nResponse String = " + responseString);
//		System.out.println("\nResponse JSON = " + responseJson.toString());
//		System.out.println("\nExtracted response from JSON Object = " + responseJson.getString("page"));
//	
//		Header[] headers = response.getAllHeaders();
//		for (Header header : headers) {
//			System.out.println(header.getValue());
//		}
	}
}
