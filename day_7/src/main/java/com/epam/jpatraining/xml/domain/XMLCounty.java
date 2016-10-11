package com.epam.jpatraining.xml.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "city")
@XmlType (propOrder={"id","name", "seat", "color", "population", "size", "pathCommands"})
public class XMLCounty {

	private String id;
	private String name;
	private String seat;
	private String color;
	private int population;
	private int size;
	private List<XMLPathCommand> pathCommands;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	@XmlElement(name = "command")
	public List<XMLPathCommand> getPathCommands() {
		return pathCommands;
	}
	public void setPathCommands(List<XMLPathCommand> pathCommands) {
		this.pathCommands = pathCommands;
	}
	
	
	
}
