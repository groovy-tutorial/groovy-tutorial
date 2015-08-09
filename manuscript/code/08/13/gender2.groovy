import groovy.transform.ToString

enum Gender {
    MALE('male'),
    FEMALE('female')

    final String value

    Gender(value) {
        this.value = value
    }

    @Override
    String toString() {
        value
    }
}

@ToString
class Person {
    String name
    String email
    String mobile
    Gender gender
}

Person jane = new Person(name: 'Jane', gender: Gender.FEMALE)
println jane

