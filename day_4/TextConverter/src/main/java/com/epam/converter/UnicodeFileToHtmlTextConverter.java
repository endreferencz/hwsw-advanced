package com.epam.converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.commons.lang3.StringEscapeUtils;

public class UnicodeFileToHtmlTextConverter {

    private String fullFilenameWithPath;

    public UnicodeFileToHtmlTextConverter(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String convertToHtml() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fullFilenameWithPath))) {
            String line = reader.readLine();
            String html = "";
            while (line != null) {
                html += StringEscapeUtils.escapeHtml4(line);
                html += "<br />";
                line = reader.readLine();
            }
            return html;
        }
    }

    public static void main(String[] args) throws IOException {
        String html = new UnicodeFileToHtmlTextConverter("test.txt").convertToHtml();
        System.out.println(html);
    }

}
