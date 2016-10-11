package com.epam.jpatraining.config;

import static javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class XMLProcessorConfig {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setMarshallerProperties(new HashMap<String, Object>() {
			{
				put(JAXB_FORMATTED_OUTPUT, true);
			}
		});
		jaxb2Marshaller.setPackagesToScan("com.epam.jpatraining.xml.domain");
		
		return jaxb2Marshaller;
	}
}
