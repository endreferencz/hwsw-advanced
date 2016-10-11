package com.epam.jpatraining.map.domain;

public class Statistics {

	private int maxSize;
	private int minSize;
	private double avgSize;
	
	private int maxPopulation;
	private int minPopulation;
	private double avgPopulation;
	
	public Statistics(int maxSize, int minSize, double avgSize, int maxPopulation, int minPopulation,
			double avgPopulation) {
		super();
		this.maxSize = maxSize;
		this.minSize = minSize;
		this.avgSize = avgSize;
		this.maxPopulation = maxPopulation;
		this.minPopulation = minPopulation;
		this.avgPopulation = avgPopulation;
	}

	@Override
	public String toString() {
		return "Statistics [maxSize=" + maxSize + ", minSize=" + minSize + ", avgSize=" + avgSize + ", maxPopulation="
				+ maxPopulation + ", minPopulation=" + minPopulation + ", avgPopulation=" + avgPopulation + "]";
	}
	
	
	
	
	
	
	
	
	
}
