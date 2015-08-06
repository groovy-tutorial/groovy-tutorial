class Person {
    private String name

    void setName(name) {
        println 'Setting name...'
        this.name = name
    }
}

Person p = new Person()
p.name = 'Bill'
println p.dump()

p.setName 'William'
println p.dump()
