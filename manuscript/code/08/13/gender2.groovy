import groovy.transform.ToString

@ToString
enum Gender {
    MALE('male'),
    FEMALE('female')

    final String displayText

    Gender(displayText) {
        this.displayText = displayText
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
