package com.api.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath= "src//test//resources//config.properties";

	
	public ConfigFileReader(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at " + propertyFilePath);
		}		
	}
	
	public String getBaseUrl(){
		String baseUrl = properties.getProperty("baseUrl");
		if(baseUrl!= null) return baseUrl;
		else throw new RuntimeException("driverPath not specified in the config.properties file.");		
	}
	
	public String getResource() {		
		String resource = properties.getProperty("resource");
		if(resource != null) return resource;
		else throw new RuntimeException("resource not specified in the config.properties file.");		
	}
}
