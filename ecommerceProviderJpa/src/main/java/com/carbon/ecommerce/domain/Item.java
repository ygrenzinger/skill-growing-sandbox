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
    @JoinColumn(name = "TEAM_ID")
    private Team team;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReference() {
		return reference;
	}

	public void setReference(Integer reference) {
		this.reference = reference;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Set<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<Stock> stocks) {
		this.stocks = stocks;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Item item = (Item) o;

		if (id != null ? !id.equals(item.id) : item.id != null) return false;
		if (description != null ? !description.equals(item.description) : item.description != null) return false;
		if (reference != null ? !reference.equals(item.reference) : item.reference != null) return false;
		if (composition != null ? !composition.equals(item.composition) : item.composition != null) return false;
		if (price != null ? !price.equals(item.price) : item.price != null) return false;
		return !(team != null ? !team.equals(item.team) : item.team != null);

	}

	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (description != null ? description.hashCode() : 0);
		result = 31 * result + (reference != null ? reference.hashCode() : 0);
		result = 31 * result + (composition != null ? composition.hashCode() : 0);
		result = 31 * result + (price != null ? price.hashCode() : 0);
		result = 31 * result + (stocks != null ? stocks.hashCode() : 0);
		result = 31 * result + (team != null ? team.hashCode() : 0);
		return result;
	}
}