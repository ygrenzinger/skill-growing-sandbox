package com.carbon.ecommerce.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "TEAM")
public class Team implements Serializable {

	private static final long serialVersionUID = -6590575895156881691L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

    @Column(name = "NAME")
	private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "team", cascade=CascadeType.ALL)
    private Set<Item> items= new HashSet<>();

	public Team() {
	}

	public void addItem(Item item) {
		items.add(item);
	}

    public Team(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}
}
