interface Exercise {
    def run(int distance)
}

class Athlete implements Exercise {
    def name

    def run(int distance) {
        println "I'm off for a ${distance}km run."
    }
}

def robert = new Athlete(name: 'Rob')
robert.run(10)
