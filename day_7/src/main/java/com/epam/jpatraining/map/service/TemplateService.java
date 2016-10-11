package com.epam.jpatraining.map.service;

import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

//@Component
public class TemplateService {

	@Autowired
	private Configuration configuration;
	

	public void create(Writer writer, String templateName, Map<String, Object> data) throws IOException, TemplateException {
		
		Template template = configuration.getTemplate(templateName);
		

		template.process(data, writer);
		writer.flush();
		writer.close();
		
	}
	
}
