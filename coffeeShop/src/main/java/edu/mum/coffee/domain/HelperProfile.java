package edu.mum.coffee.domain;

import javax.validation.Valid;

public class HelperProfile {
	
@Valid
private Person person;

private Users user;


public Person getPerson() {
	return person;
}
public void setPerson(Person person) {
	this.person = person;
}
public Users getUser() {
	return user;
}
public void setUser(Users user) {
	this.user = user;
}


}
