package com.epam.training.javasecurity.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class H2Initializer {

	@Bean
	public ServletRegistrationBean h2Servlet() {
		ServletRegistrationBean servletBean = new ServletRegistrationBean();
		servletBean.addUrlMappings("/admin/h2/*"); 
		servletBean.setServlet(new WebServlet());
		return servletBean;
	}
}
