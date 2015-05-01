package com.carbon.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "STOCK")
public class Stock implements Serializable {

	private static final long serialVersionUID = 377046055448316454L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "SIZE", nullable = false)
	private Size size;
	
	@Column(name = "AVAILABLE", nullable = false)
	private int available = 0;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private Item item;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}
	
}