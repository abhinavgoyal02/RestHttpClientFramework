package com.autoqa.framework.apitest.httpclientcore;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.autoqa.framework.apitest.httpclientbase.TestBase;
import com.autoqa.framework.apitest.httpclientcore.HTTPClient;
import com.autoqa.framework.apitest.utils.TestUtils;

public class GetCallTest extends TestBase {
		
	private String URI = null;
	
	public GetCallTest() throws FileNotFoundException, IOException {
		super();
	}
	
	@BeforeTest
	public void setUp(){
		String url = prop.getProperty("URL");
		String resource = prop.getProperty("ServiceResource");
		URI = url + resource; 
	}

	@Test (enabled=false)
	public void testGetCall() throws FileNotFoundException, IOException, JSONException {
		 CloseableHttpResponse response = HTTPClient.getCall(URI);
		 
		 Assert.assertEquals(response.getStatusLine().getStatusCode(), RESPONSE_CODE_200);
	}
	
	@Test
	public void testGetCallResponse() throws ParseException, IOException, JSONException{
		CloseableHttpResponse response = HTTPClient.getCall(URI);
		String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
		
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("API Response JSON = " + responseJson);
		
		String jPath = "/page";
		String jValue = TestUtils.getValueJPath(responseJson, jPath);
		System.out.println("JSON Response Page = " + jValue);
		Assert.assertEquals(jValue, "4");
		
		jPath = "/data[1]/last_name";
		jValue = TestUtils.getValueJPath(responseJson, jPath);
		System.out.println("JSON Response Last Name [1] = " + jValue);
		Assert.assertEquals(jValue, "Edwards");
		
		jPath = "/data[2]/avatar";
		jValue = TestUtils.getValueJPath(responseJson, jPath);
		System.out.println("JSON Response Value [2] = " + jValue);
		Assert.assertEquals(jValue, "https://s3.amazonaws.com/uifaces/faces/twitter/hebertialmeida/128.jpg");
		
		
	}
	
}
