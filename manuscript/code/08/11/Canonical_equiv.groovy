import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@EqualsAndHashCode
@TupleConstructor
class Person {
    def name
    def email
    def mobile
}

Person phil = new Person('Phil', '041414141')

println phil
