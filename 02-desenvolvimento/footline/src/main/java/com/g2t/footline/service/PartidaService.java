package com.g2t.footline.service;

public class PartidaService {

	private static PartidaService uniqueInstance;

	private PartidaService() { 
	}

	public static synchronized PartidaService getInstance() {
		if (uniqueInstance == null)
			uniqueInstance = new PartidaService();
		return uniqueInstance;
	}
	
}