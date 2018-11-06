package com.autoqa.framework.apitest.httpclientbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public Properties prop = null;
	private final static String PROP_FILEPATH = "\\src\\main\\java\\com\\autoqa\\framework\\apitest\\httpclientconfig\\";
	private final static String PROP_FILENAME = "config.properties";
	public static final int RESPONSE_CODE_200 = 200;
	public static final int RESPONSE_CODE_201 = 201;
	public static final int RESPONSE_CODE_400 = 400;
	public static final int RESPONSE_CODE_401 = 401;
	public static final int RESPONSE_CODE_404 = 404;
	public static final int RESPONSE_CODE_500 = 500;
	
	public TestBase() throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileInputStream(System.getProperty("user.dir") + PROP_FILEPATH + PROP_FILENAME));

	}
}
