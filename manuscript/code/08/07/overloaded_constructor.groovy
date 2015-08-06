class Person {
    private name
    def email
    def mobile

    Person(name) {
        this.name = name
    }

    Person(name, email) {
        this(name)
        this.email = email
    }
}

def astrid = new Person('Astrid Smithson', 'astrid@example.com')
println astrid.dump()
