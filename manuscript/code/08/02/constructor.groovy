class Person {
    def name

    Person(name) {
        this.name = name
    }

    def getName() {
        this.name
    }
}

def john = new Person('John')

println john.dump()
