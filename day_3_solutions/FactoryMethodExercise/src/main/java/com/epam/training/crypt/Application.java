package com.epam.training.crypt;

public class Application {

    public static void main(String[] args) {
        Encryptor caesarEncryptor = new CaesarEncryptor(5);
        Decryptor caesarDecryptor = caesarEncryptor.createDecryptor();
        System.out.println("Encrypt this -> " + caesarDecryptor.decrypt(caesarEncryptor.encrypt("Encrypt this")));

        Encryptor easyEncryptor = new EasyEncryptor("Key");
        Decryptor easyDecryptor = easyEncryptor.createDecryptor();
        System.out.println("Encrypt this -> " + easyDecryptor.decrypt(easyEncryptor.encrypt("Encrypt this")));
    }

}
