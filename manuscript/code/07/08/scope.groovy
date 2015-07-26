class Contact {
    def name
    def phone

    //A closure for calling the contact
    final call = { message ->
        println "Calling ${this.name} on ${this.phone} with the message: '$message'"
    }
}

def andrew = new Contact(name: 'Andrew', phone: '+61 432 321 736')
def sally = new Contact(name: 'Sally', phone: '+61 400 800 900')

def needToCallBack = [ ]
needToCallBack << andrew.call
needToCallBack << sally.call

// Lots of other code ......

andrew = null
sally = null

needToCallBack.each { it('It\'s Duncan here, sorry I missed your call') }
