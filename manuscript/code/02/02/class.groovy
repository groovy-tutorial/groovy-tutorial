class Person {
    def name
    def email
}

def david = new Person(name: 'David', email: 'david@example.com')

println david.class.name
