package com.epam.cache;

import com.epam.cache.util.CacheMonitor;

public class Monitor {

	private CacheMonitor cacheMonitor;

	public Monitor(CacheMonitor cacheMonitor) {
		this.cacheMonitor = cacheMonitor;
	}
	
	public void printInfo() {
		System.out.println("Cache info:");
		for (String key : cacheMonitor.getKeys()) {
			System.out.println("Element: " + key);
			System.out.println("Last access: " + cacheMonitor.getLastAccess(key));
			System.out.println("Number of hits: " + cacheMonitor.getNumHits(key));
		}
	}
	
}
