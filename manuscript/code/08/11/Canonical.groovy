@groovy.transform.Canonical
class Person {
    def name
    def email
    def mobile
}

Person phil = new Person('Phil', '041414141')

println phil
