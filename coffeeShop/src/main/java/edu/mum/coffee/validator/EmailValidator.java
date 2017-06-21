package edu.mum.coffee.validator;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.coffee.domain.Person;
import edu.mum.coffee.exception.PersonNotFoundException;
import edu.mum.coffee.service.PersonService;

public class EmailValidator implements
ConstraintValidator<Email, String>{
@Autowired
private PersonService personService;

public void initialize(Email constraintAnnotation) {
    //  intentionally left blank; this is the place to initialize the constraint annotation for any sensible default values.
}  
public boolean isValid(String value, ConstraintValidatorContext context) {
    List<Person> person;
    System.out.println("ENTRO AL VALIDATOR "+ value);
    try {
       person = personService.findByEmail(value);
    } catch (PersonNotFoundException E) {
       return true;
    }catch (Exception E) {
        return true;
     }
    
    //if(person!= null) {
    if(!person.isEmpty()) {
       return false;
    }
    return true;
 }
}