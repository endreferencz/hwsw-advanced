package com.epam.training.crypt;

public class CaesarEncryptor implements Encryptor {

	private int key;

	public CaesarEncryptor(int key) {
		this.key = key;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	@Override
	public String encrypt(String toEncrypt) {
		char[] chars = toEncrypt.toCharArray();
		for (int i = 0; i < toEncrypt.length(); i++) {
			char c = chars[i];
			if (c >= 32 && c <= 127) {
				int x = c - 32;
				x = (x + key) % 96;
				if (x < 0)
					x += 96;
				chars[i] = (char) (x + 32);
			}
		}
		return new String(chars);
	}

	@Override
	public Decryptor createDecryptor() {
		return new Decryptor() {
            @Override
			public String decrypt(String toDecrypt) {
				return new CaesarEncryptor(-key).encrypt(toDecrypt);
			}
		};
	}
	
}
