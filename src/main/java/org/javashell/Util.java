package main.java.org.javashell;

public class Util {
	
	public static void systemProperty(String property, String value){
		System.getProperties().put(property, value);
	}

}
