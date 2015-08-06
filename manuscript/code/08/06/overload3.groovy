class Person {
    String name

    def exercise() {
        println 'I am exercising but I\'m not sure for how long'
    }

    def exercise(Integer duration) {
        println "I am exercising for $duration minutes"
    }

    def exercise(String activity) {
        println "I think I'll go for a $activity"
    }

    def exercise(String activity, Integer duration) {
        exercise(activity)
        exercise(duration)
    }
}

Person sam = new Person(name: 'Sam')

sam.exercise()
sam.exercise(10)
sam.exercise('walk')
sam.exercise('jog', 30)
