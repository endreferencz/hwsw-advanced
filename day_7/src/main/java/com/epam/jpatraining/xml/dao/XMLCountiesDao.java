package com.epam.jpatraining.xml.dao;


import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;
import org.springframework.stereotype.Component;

import com.epam.jpatraining.xml.domain.XMLCounties;

@Component
public class XMLCountiesDao {

	@Autowired
	private Marshaller marshaller;
	
	@Autowired
	private Unmarshaller unmarshaller;

	
	public void write(XMLCounties xmlCounties, Result result) throws XmlMappingException, IOException {
		marshaller.marshal(xmlCounties, result);
	}

	public XMLCounties read(Source source) throws IOException {
		return (XMLCounties) unmarshaller.unmarshal(source);
	}
	
}
