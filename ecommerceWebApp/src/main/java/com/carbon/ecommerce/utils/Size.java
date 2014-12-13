package com.carbon.ecommerce.utils;

public enum Size {

	S("small"), M("medium"), L("large"), XL("extra large");
	
	private String libelle;
	
	private Size(String libelle) {
		this.libelle = libelle; 
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public static Size find(String val) {
		for (Size size : Size.values()) {
			if (size.getLibelle() == val) {
				return size;
			}
		}
		return null;
	}
}
