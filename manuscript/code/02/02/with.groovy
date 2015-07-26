class Person {
    def name
    def email
}

def david = new Person(name: 'David', email: 'david@example.com')

david.with {
    println name
    println email
}
