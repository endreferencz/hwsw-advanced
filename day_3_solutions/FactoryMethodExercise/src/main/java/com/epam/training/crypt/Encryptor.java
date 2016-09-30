package com.epam.training.crypt;

public interface Encryptor {

	String encrypt(String toEncrypt);

	Decryptor createDecryptor();
	
}
