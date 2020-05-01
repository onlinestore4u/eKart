package com.bookstore.bookstore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@OneToOne
	private ShippingAddress shippingaddress;
	@OneToOne
	private Payment payment;
	@OneToOne
	private BillingAddress billingaddress;
	
	
	public Order(Long id, ShippingAddress shippingaddress, Payment payment, BillingAddress billingaddress) {
		super();
		this.id = id;
		this.shippingaddress = shippingaddress;
		this.payment = payment;
		this.billingaddress = billingaddress;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public ShippingAddress getShippingaddress() {
		return shippingaddress;
	}
	public void setShippingaddress(ShippingAddress shippingaddress) {
		this.shippingaddress = shippingaddress;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public BillingAddress getBillingaddress() {
		return billingaddress;
	}
	public void setBillingaddress(BillingAddress billingaddress) {
		this.billingaddress = billingaddress;
	}
   
	
	
	
}
