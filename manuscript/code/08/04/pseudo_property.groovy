import java.time.LocalDate
import java.time.Period

class Person {
    String name
    LocalDate dateOfBirth

    Integer getAge() {
        Period.between(dateOfBirth, LocalDate.now()).years
    }
}

Person jim = new Person(dateOfBirth: LocalDate.of(1983, 06, 04))
println jim.age
