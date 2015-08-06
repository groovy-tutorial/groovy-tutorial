class Person {
    String name
    String email

    String getContact() {
        "$name <$email>"
    }
}

Person jenny = new Person(name: 'Jenny', email: 'jen@example.com')
println jenny.getContact()

Person dave = new Person(name: 'Dave', email: 'dave@example.com')
println dave.getContact()
