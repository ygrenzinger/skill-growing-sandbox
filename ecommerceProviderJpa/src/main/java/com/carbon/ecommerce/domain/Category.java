package com.carbon.ecommerce.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

	private static final long serialVersionUID = -6590575895156881691L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

    @Column(name = "NAME")

	private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item", cascade=CascadeType.ALL)
    private Set<Item> items;



    public Category(String name, String firstName, String email,
                    String password) {
		this.name = name;
	}

	public Category() {
		super();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}


    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }



}
