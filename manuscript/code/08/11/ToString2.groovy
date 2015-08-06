@groovy.transform.ToString(includeNames=true, includeFields=true)
class Person {
    def name
    private email
    private mobile

    Person(name) {
        this.name = name
    }
}

def astrid = new Person('Astrid Smithson')

println astrid
