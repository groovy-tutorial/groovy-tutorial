class Person {
    UUID id
    String name

    {
        this.name = 'Anonymous'
        this.id = UUID.randomUUID()
    }
}

Person paul = new Person()
println paul.dump()
