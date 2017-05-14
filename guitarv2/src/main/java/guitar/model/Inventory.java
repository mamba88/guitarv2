package com.guitar.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	private static List<Guitar> guitars = null;
	
	public Inventory() {
		setGuitars(new LinkedList<Guitar>());
	}
	
	public void addGuitar(String serialNumber, double price, String model, GuitarSpec spec) {
		Guitar guitar = new Guitar(serialNumber, price, model,  spec);
		getGuitars().add(guitar);
	}
		
	public List<Guitar> search(GuitarSpec searchSpec) {
		List<Guitar> guitars = new LinkedList<Guitar>();
		
		for (Iterator<Guitar> i = getGuitars().iterator(); i.hasNext(); ) {
			
			Guitar guitar = (Guitar)i.next();
			
			if (guitar.getSpec().matches(searchSpec)){
				guitars.add(guitar);
			}				
		}
		return guitars;
	}

	public static List<Guitar> getGuitars() {
		return guitars;
	}

	public static void setGuitars(List<Guitar> guitars) {
		Inventory.guitars = guitars;
	}
}
