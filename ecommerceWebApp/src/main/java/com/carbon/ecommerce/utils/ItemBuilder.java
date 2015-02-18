package com.carbon.ecommerce.utils;


public class ItemBuilder {

	private String description;
	
	private Integer reference;
	
	private String composition;

	private Float price;

	private String size;
	
	public ItemBuilder(){
	}

	public ItemBuilder description(String description) {
         this.description = description;
         return this;
     }
	  
	 public ItemBuilder reference(Integer reference) {
	         this.reference = reference;
	         return this;
   }
	  
	  public ItemBuilder composition(String composition) {
	         this.composition = composition;
	         return this;
	  }
	  
	  public ItemBuilder price(Float price) {
	         this.price = price;
	         return this;
	 }
	  
	  public ItemBuilder size(String size) {
		  this.size = size;
		  return this;
	  }
	  
	  public Item createItem(){
         return new Item(
            description, reference, composition, price, size);
      }
}
