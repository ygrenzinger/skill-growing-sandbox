package com.carbon.ecommerce.utils;


public class Item {

	private String description;
	
	private Integer reference;
	
	private String composition;

	private Float price;

	private String size;
	
	
	public Item() {
		super();
	}
	public Item(String description, Integer reference, String composition,
			Float price, String size) {
		super();
		this.description = description;
		this.reference = reference;
		this.composition = composition;
		this.price = price;
		this.size = size;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the reference
	 */
	public Integer getReference() {
		return reference;
	}
	/**
	 * @param ref the ref to set
	 */
	public void setReference(Integer reference) {
		this.reference = reference;
	}
	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}
	
	
}