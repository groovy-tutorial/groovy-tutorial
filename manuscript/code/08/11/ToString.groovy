@groovy.transform.ToString
class Person {
    def name
    def email
    def mobile

    Person(name) {
        this.name = name
    }
}

def astrid = new Person('Astrid Smithson')

println astrid
