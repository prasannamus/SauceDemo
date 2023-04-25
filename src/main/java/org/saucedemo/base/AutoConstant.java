package org.saucedemo.base;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * class : AutoConstant
 * author: prasanna suman
 * This class will be used to store
 * 		1. resources paths
 * 		2. Test Data
 */
public class AutoConstant {
	static final String propertyfilePath = "./src/test/resources/config.properties";
	public static final String webPageTitle = "Swag Labs";
	
	
	// Test Data
	public static final String userName = "standard_user";
	public static final String password = "secret_sauce";
	public static final Map<String, String> sortValues = new HashMap<String, String>(){{
		put("Price (high to low)", "hilo");
		put("Price (low to high)", "lohi");
		put("Name (A to Z)", "az");
		put("Name (Z to A)", "za");
	}};
	public static final int product = 2;
	public static final String productName = "sauce-labs-bike-light";
	public static final List<Integer> productList = new ArrayList<Integer>(){{
		add(3);
		add(2);
		add(1);
	}};
	
}
