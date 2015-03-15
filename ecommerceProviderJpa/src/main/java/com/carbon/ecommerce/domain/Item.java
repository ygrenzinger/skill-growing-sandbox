package com.carbon.ecommerce.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ITEM")
public class Item implements Serializable{

	private static final long serialVersionUID = 377046055448316454L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "REFERENCE")
	private Integer reference;
	
	@Column(name = "COMPOSITION")
	private String composition;

	@Column(name = "PRICE")
	private Float price;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade=CascadeType.ALL)
	private Set<Stock> stocks;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private Category category;

    public Set<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
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
	 * @param reference the ref to set
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
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	public String getComposition() {
		return composition;
	}
	public void setComposition(String composition) {
		this.composition = composition;
	}

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}