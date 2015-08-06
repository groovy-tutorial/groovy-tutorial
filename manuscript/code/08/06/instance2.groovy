class Person {
    String name
    String email

    void setName(name) {
        this.name = name
    }

    String getContact() {
        "$name <$email>"
    }
}

Person jenny = new Person()
jenny.setName('Jenny')
jenny.setEmail('jen@example.com')
println jenny.getContact()

