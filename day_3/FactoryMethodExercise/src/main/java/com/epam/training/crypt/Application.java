package com.epam.training.crypt;

public class Application {

	public static void main(String[] args) {
		Encryptor caesarEncryptor = new CaesarEncryptor(5);
		System.out.println("Encrypt this -> " + caesarEncryptor.encrypt("Encrypt this"));

		Encryptor easyEncryptor = new EasyEncryptor("Key");
		System.out.println("Encrypt this -> " + easyEncryptor.encrypt("Encrypt this"));
	}

}
