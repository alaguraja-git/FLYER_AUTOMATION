package com.qa.util;

import java.util.Base64;
import java.util.Base64.Decoder;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.qa.factory.DriverFactory;

public class ElementUtil {
	
	public static void highlightElement(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getDriver();
		executor.executeScript("arguments[0].setAttribute('style','border: 3px solid blue');",element);
	}
	
	
	// Decryption technique
	public static String decryptPassword(String encodedString) {
		Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(encodedString);
		//System.out.println("decrypted value::"+new String(bytes));
		
		return new String(bytes);
	}

}
