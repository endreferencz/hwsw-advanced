package com.epam.training.copy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class PageDownloader {

    public static void main(String[] args) throws IOException {
        new PageDownloader().download();
    }

    public void download() throws IOException {
        URL url = new URL("https://www.epam.com/");
        
        try (InputStream is = url.openStream(); OutputStream os = new FileOutputStream("out.txt")) {
            copy(is, os);
        }
    }

	private void copy(InputStream is, OutputStream os) throws IOException {
		int data;
		while ((data = is.read()) >= 0) {
		    os.write(data);
		}
	}

}
