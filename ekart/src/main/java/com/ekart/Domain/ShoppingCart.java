package com.bookstore.bookstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
		
	@OneToMany(mappedBy="shoppingCart",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<CartItem> cartitem;
	
	

}
