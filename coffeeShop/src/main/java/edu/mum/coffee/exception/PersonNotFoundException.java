package edu.mum.coffee.exception;

public class PersonNotFoundException extends
    RuntimeException{
       private static final long serialVersionUID =
       -694354952032299587L;
       
       private String email;
       
       public PersonNotFoundException(String Email) {
          this.email = email;
       }
       public String getEmail() {
    	    return email;
       }
}
