trait Running {
    void startEvent() {
        println 'Ready, set, go!'
    }
}

class SportingEvent implements Running {
    String name
}

SportingEvent stawellGift = new SportingEvent(name: 'The Stawell Gift')

println "Welcome to $stawellGift.name"
stawellGift.startEvent()
