package com.qa.util;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class Encryption_Decryption {

	public static void main(String[] args) {
		Encoder encoder = Base64.getEncoder();
		String originalString = "Usilampatti@1234";
		String encodedString = encoder.encodeToString(originalString.getBytes());
		System.out.println("EncryptedValue::"+encodedString);

		
		Decoder decoder = Base64.getDecoder();
		byte[] bytes = decoder.decode(encodedString);
		System.out.println("decrypted value::"+new String(bytes));

	}

}
