 package com.guitar.model;

public class Guitar {
	private String serialNumber;
	private double price;
	private String model;
	
	GuitarSpec spec;
	
	public Guitar(String serialNumber, double price, String model,  GuitarSpec spec) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.model = model;
		
		this.spec = spec;
	}

	public Guitar(){
		
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public GuitarSpec getSpec() {
		return spec;
	}
	public void setSpec(GuitarSpec spec){
		this.spec = spec;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

}
