/*
 * This script demonstrates why you should protect closures belonging to a class
 */
 
/**
 * A basic class for handling contacts
 */
class Contact {
    def name, email, phone
    
    /** A closure for calling the contact */
    def call = { 
        println "Calling ${this.name} on ${this.phone}."
    }
}


def andrew = new Contact(name: 'Andrew', email: 'andrew@example.com', phone: '+61 432 321 736')

andrew.call = {println 'I\'ve hacked your phone system'}

andrew.call()

//---------------------------------------------------------------------------//

/**
 * A basic class for handling contacts - but with a better version of the `call` closure
 * that uses an ignorant setter to stop modifications
 */
class Contact2 {
    def name, email, phone
    
    /** A closure for calling the contact */
    def call = { 
        println "Calling ${this.name} on ${this.phone}."
    }
    
    /**
     * This setter will just ignore your attempts to hack the class
     */
    def setCall(closure) {
    }
}

def greg = new Contact2(name: 'Greg', email: 'greg@example.com', phone: '+61 402 747 380')

//This will fail:
greg.call = {println 'I\'ve hacked your phone system'}
greg.call()

//---------------------------------------------------------------------------//

/**
 * A basic class for handling contacts - but with a better version of the `call` property
 * that uses `final` to stop modifications
 */
class Contact3 {
    def name, email, phone
    
    /** A closure for calling the contact - uses `final` to stop people making modifications */
    def final call = { 
        println "Calling ${this.name} on ${this.phone}."
    }
}

def sally = new Contact3(name: 'Sally', email: 'sally@example.com', phone: '+61 400 800 900')

//This will fail:
sally.call = {println 'I\'ve hacked your phone system'}
