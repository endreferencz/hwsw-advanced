package com.epam.converter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class UnicodeFileToHtmlTextConverterTest {

    @Test
    public void testConvertToHtml() throws IOException {
        // Given
        BufferedReader reader = mock(BufferedReader.class);
        when(reader.readLine()).thenReturn("First line", (String) null);
        UnicodeFileToHtmlTextConverter converter = new UnicodeFileToHtmlTextConverter("");

        // When
        String result = converter.convertToHtml(reader);

        // Then
        verify(reader, Mockito.times(2)).readLine();
        Assert.assertEquals("First line<br />", result);
    }

}
