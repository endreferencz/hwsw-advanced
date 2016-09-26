package com.epam.training;

import com.epam.training.crypt.CaesarEncryptor;
import com.epam.training.crypt.EasyEncryptor;
import com.epam.training.crypt.Encryptor;

public class Application {

	public static void main(String[] args) {
		Encryptor caesarEncryptor = new CaesarEncryptor(5);
		System.out.println("Encrypt this -> " + caesarEncryptor.encrypt("Encrypt this"));

		Encryptor easyEncryptor = new EasyEncryptor("Key");
		System.out.println("Encrypt this -> " + easyEncryptor.encrypt("Encrypt this"));
	}

}
