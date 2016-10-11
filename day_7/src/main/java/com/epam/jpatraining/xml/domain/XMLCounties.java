package com.epam.jpatraining.xml.domain;

import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "counties")
public class XMLCounties {

    private List<XMLCounty> counties = new LinkedList<>();

    @XmlElement(name = "county")
	public List<XMLCounty> getCounties() {
		return counties;
	}


	public void setCounties(List<XMLCounty> counties) {
		this.counties = counties;
	}

	
}
