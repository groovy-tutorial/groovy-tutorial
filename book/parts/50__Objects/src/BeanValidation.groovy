@Grapes([
  @Grab(group='org.hibernate', module='hibernate-validator', version='5.1.2.Final'), 
  @Grab(group='org.hibernate', module='hibernate-validator-cdi', version='5.1.2.Final'),
  @Grab(group='javax.el', module='el-api', version='2.2.4'),
  @Grab(group='org.glassfish.web', module='el-api', version='2.2.4')
]) 

import groovy.transform.Canonical
import groovy.transform.ToString
import javax.validation.constraints.*
import org.hibernate.validator.constraints.*

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory

/**
 * See: http://beanvalidation.org/
 * JSR 349
 * Beans: http://docs.oracle.com/javase/tutorial/javabeans/
 * and groovy.beans.*
 *
 * See https://docs.jboss.org/hibernate/validator/5.1/api/
 */

@Canonical
@ToString(includeNames=true)
class Party {
    @NotEmpty @Email
    String rsvpEmail
    
    @NotNull
    Date rsvpDate
    
    @NotNull
    Date date
    
    @Size(max = 10)
    Person[] guests = [] as Set
}

@Canonical
class Person {
    @NotNull
    String name
    
    @NotNull @Email
    String email
}

Party dinnerParty = new Party()

dinnerParty.rsvpEmail = 'me@test.com'

ValidatorFactory factory = Validation.buildDefaultValidatorFactory()
Validator validator = factory.getValidator()
Set<ConstraintViolation<Party>> constraintViolations = validator.validate( party )

println dinnerParty.toString()