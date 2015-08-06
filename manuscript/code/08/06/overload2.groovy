class Person {
    String name

    def exercise() {
        //Generate a random number using java.util.Random
        Random random = new Random()

        //Use nextInt to get a random number between 0 and 120
        exercise(random.nextInt(120))
    }

    def exercise(duration) {
        println "I am exercising for $duration minutes"
    }
}

Person sam = new Person(name: 'Sam')

sam.exercise()

