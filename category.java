package com.productcategory.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name="category")
public class category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	
	
	 public category()
	    {
	    	
	    }
	 
	
	public category(long id, String name, List<com.productcategory.model.products> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<products> getProducts() {
		return products;
	}

	public void setProducts(List<products> products) {
		this.products = products;
	}
	
	@OneToMany(mappedBy = "category")
	 private List<products> products;
	 
}
