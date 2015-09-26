trait Running {
    void startEvent() {
        println 'Ready, set, go!'
    }

    private String slow() {}
}

class SportingEvent implements Running {
    String name

    private String rigWinner() {
        'We know that Jane will win this'
    }
}

SportingEvent race = new SportingEvent(name: 'The Dodgy Race')

println "Welcome to $race.name"
println race.rigWinner()
race.slow()
