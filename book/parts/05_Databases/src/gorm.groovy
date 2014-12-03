@Grab('org.grails:gorm-hibernate4-spring-boot:1.1.0.RELEASE')
@Grab('org.hsqldb:hsqldb:2.3.2')

import org.springframework.boot.SpringApplication
import grails.persistence.*

// To run this script: spring run gorm.groovy

@Entity
class Person {
    String firstName
    
    static hasOne = [role:Role]
    
    static constraints = {
        firstName blank: false 
    }
}

@Entity
class Role {
    String name
}

['Manager', 'Analyst', 'SysAdmin'].each {
    def r = new Role(it)
    r.save
}

println Role.list()