package com.bookstore.bookstore.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bookstore.bookstore.security.Authority;
import com.bookstore.bookstore.security.UserRole;

@Entity
public class User implements UserDetails {//with UserDetails we can customize Spring Security and privileges

	@Id
	@Column(name="id",nullable=false,updatable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String fastName;
	private String lastName;
	@Column(name="email",nullable=false,updatable=false)
	private String email;
	private String username;
	private String mobile;
	private String password;
	private boolean enable=true;
	@OneToOne
	private ShoppingCart shoppingcart;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<UserPayment> userpayment;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Set<UserBilling> userbilling;
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<UserRole> userrole=new HashSet<>();
	
	public User(){
		
	}
	
	
	public User(Long id, String fastName, String lastName, String email, String username, String mobile,
			String password, boolean enable, ShoppingCart shoppingcart, Set<UserPayment> userpayment,
			Set<UserBilling> userbilling, Set<UserRole> userrole) {
		super();
		this.id = id;
		this.fastName = fastName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.mobile = mobile;
		this.password = password;
		this.enable = enable;
		this.shoppingcart = shoppingcart;
		this.userpayment = userpayment;
		this.userbilling = userbilling;
		this.userrole = userrole;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFastName() {
		return fastName;
	}
	public void setFastName(String fastName) {
		this.fastName = fastName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public ShoppingCart getShoppingcart() {
		return shoppingcart;
	}
	public void setShoppingcart(ShoppingCart shoppingcart) {
		this.shoppingcart = shoppingcart;
	}
	public Set<UserPayment> getUserpayment() {
		return userpayment;
	}
	public void setUserpayment(Set<UserPayment> userpayment) {
		this.userpayment = userpayment;
	}
	public Set<UserBilling> getUserbilling() {
		return userbilling;
	}
	public void setUserbilling(Set<UserBilling> userbilling) {
		this.userbilling = userbilling;
	}
	public Set<UserRole> getUserrole() {
		return userrole;
	}
	public void setUserrole(Set<UserRole> userrole) {
		this.userrole = userrole;
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities= new HashSet<>();
		userrole.forEach(ur->authorities.add(new Authority(ur.getRole().getName())));//here we add authority to each of the userrole
		
		return authorities;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", fastName=" + fastName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", mobile=" + mobile + ", password=" + password + ", enable=" + enable
				+ ", shoppingcart=" + shoppingcart + ", userpayment=" + userpayment + ", userbilling=" + userbilling
				+ ", userrole=" + userrole + "]";
	}


	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enable;
	}
	
	
	
	
	
	
	

}
