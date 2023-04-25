package org.saucedemo.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/*
 * class: PropertyFile
 * author: prasanna suman
 * purpose: to read the config.properties file to set or get test configurations
 */
public class PropertyFile {

public String getData(String key) throws IOException {
		
		Properties p=new Properties();
		FileInputStream fis = new FileInputStream(AutoConstant.propertyfilePath);
		p.load(fis);
		return p.getProperty(key);
	}
}
