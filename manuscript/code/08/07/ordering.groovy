class Person {
    private String name

    ;{
        this.name = 'Anonymous'
        println "Initialised default name to ${this.name}"
    }

    public Person(name) {
        this.name = name
        println "Constructor called with name: ${this.name}"
    }

    public void setName(name){
        this.name = name
        println "setName called. Name is now: ${this.name}"
    }

    public void changeName(name) {
        this.name = name
        println "changeName called. Name is now: ${this.name}"
    }
}

Person fred = new Person('Fred')

println "After instantiation, name is: $fred.name"

fred.name = 'Freda'

fred.changeName 'Frederique'
