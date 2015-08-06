class Person {
    String name

    def exercise() {
        println 'I am exercising but I\'m not sure for how long'
    }

    def exercise(duration = 10) {
        println "I am exercising for $duration minutes"
    }
}

Person sam = new Person(name: 'Sam')

sam.exercise()
sam.exercise(10)
