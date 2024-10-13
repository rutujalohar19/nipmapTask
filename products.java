package com.productcategory.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="products") 
public class products {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	 private Long id;
    private String name;
    private double price;

    public products()
    {
    	
    }
    
    
    public products(Long id, String name, double price, com.productcategory.model.category category) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.category = category;
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


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public category getCategory() {
		return category;
	}


	public void setCategory(category category) {
		this.category = category;
	}

	
	@ManyToOne
    @JoinColumn(name = "category_id")
    private category category;

}
