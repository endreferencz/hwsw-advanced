package com.epam.training.crypt;

import java.io.Serializable;

public interface Decryptor extends Serializable {

	String decrypt(String toDecrypt);

}
