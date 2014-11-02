class Person {
    def name
    def email
    
    def getName() {
        return this.name
    }
    
    def setName(name) {
        this.name = name
    }
    
    def getEmail() {
        return this.email
    }
    
    def seteEmail(email) {
        this.email = email
    }
}

// Create a new variable to hold an instance of the Person class
def david = new Person(name: 'David', email: 'david@example.com')

// Change David's email address:
david.setEmail('dave@example.com')

// Print out David's information
println """\
Name:\t ${david.getName()}
Email:\t ${david.getEmail()}
"""