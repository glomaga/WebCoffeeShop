package edu.mum.coffee.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Authorities {
	
	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	private Users username;
	
	private String authority;
	public Users getUsername() {
		return username;
	}
	public void setUsername(Users username) {
		this.username = username;
	}
	public String getAuthority() {
		return authority;
	}
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	

}
