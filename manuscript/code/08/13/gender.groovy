import groovy.transform.ToString

enum Gender {
    MALE,
    FEMALE
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
