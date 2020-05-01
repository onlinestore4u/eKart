package com.bookstore.bookstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@Column(name="bookId",nullable=false,unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String tittle;
	private String author;
    private String publisher;
    private String publicationDate;
    private String language;
    private String category;
    private int numberOfPages;
    private String format;
    private String isbn;
    private Double shippingWeight;
    private Double listprice;
    private Double ourPrice;
    private boolean active;
    @ManyToOne
    @JoinColumn(name="cartitem_id")
    private CartItem cartItem;
 
    
	public Book(Long id, String tittle, String author, String publisher, String publicationDate, String language,
			String category, int numberOfPages, String format, String isbn, Double shippingWeight, Double listprice,
			Double ourPrice, boolean active, CartItem cartItem) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.author = author;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
		this.language = language;
		this.category = category;
		this.numberOfPages = numberOfPages;
		this.format = format;
		this.isbn = isbn;
		this.shippingWeight = shippingWeight;
		this.listprice = listprice;
		this.ourPrice = ourPrice;
		this.active = active;
		this.cartItem = cartItem;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public Double getShippingWeight() {
		return shippingWeight;
	}
	public void setShippingWeight(Double shippingWeight) {
		this.shippingWeight = shippingWeight;
	}
	public Double getListprice() {
		return listprice;
	}
	public void setListprice(Double listprice) {
		this.listprice = listprice;
	}
	public Double getOurPrice() {
		return ourPrice;
	}
	public void setOurPrice(Double ourPrice) {
		this.ourPrice = ourPrice;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	public CartItem getCartItem() {
		return cartItem;
	}


	public void setCartItem(CartItem cartItem) {
		this.cartItem = cartItem;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", tittle=" + tittle + ", author=" + author + ", publisher=" + publisher
				+ ", publicationDate=" + publicationDate + ", language=" + language + ", category=" + category
				+ ", numberOfPages=" + numberOfPages + ", format=" + format + ", isbn=" + isbn + ", shippingWeight="
				+ shippingWeight + ", listprice=" + listprice + ", ourPrice=" + ourPrice + ", active=" + active + "]";
	}
    
    
}

