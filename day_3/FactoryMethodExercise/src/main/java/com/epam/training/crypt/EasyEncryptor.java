package com.epam.training.crypt;

public class EasyEncryptor implements Encryptor {

	private String key;

	public EasyEncryptor(String key) {
		super();
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Override
	public String encrypt(String toEncrypt) {
		return key + toEncrypt + key;
	}

}
