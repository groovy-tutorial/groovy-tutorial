/*
 * This script demonstrates a closure's ability to hold onto an instance
 * even though you've dereferenced the variable you've stored it into
 */
 
/**
 * A basic class for handling contacts
 */
class Contact {
    def name, email, phone
    
    /** A closure for calling the contact */
    def final call = { message -> 
        println "Calling ${this.name} on ${this.phone} with the message: \"$message\""
    }
}


def andrew = new Contact(name: 'Andrew', email: 'andrew@example.com', phone: '+61 432 321 736')
def sally = new Contact(name: 'Sally', email: 'sally@example.com', phone: '+61 400 800 900')

// This is our list of people to call back
def needToCallBack = []
needToCallBack << andrew.call
needToCallBack << sally.call

// Andrew changed his number
andrew.setPhone('+61 401 505 404')


// Now somewhere in our code we no longer explicitly track our contacts
andrew = null
sally = null

// However, we can still call them as we stored the closure in our call back list
needToCallBack.each { it('It\'s Duncan here, sorry I missed your call') }