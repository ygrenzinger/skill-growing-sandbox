package com.carbon.ecommerce.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "REFERENCE_SIZE")
public class ReferenceSize implements Serializable {
	
	private static final long serialVersionUID = 64890854426954334L;
	
	@Id
	@Column(name = "SIZE")
	private String size;
	
	
	public ReferenceSize() {
		super();
	}

	public ReferenceSize(String size) {
		this.size = size;
	}
	
	
	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}
}
