trait Running {
    Integer distance

    void startEvent() {
        println 'Ready, set, go!'
    }
}

class SportingEvent implements Running {
    String name
}

SportingEvent stawellGift = new SportingEvent(name: 'The Stawell Gift', distance: 120)

println "Welcome to $stawellGift.name - a ${stawellGift.distance}m race"
stawellGift.startEvent()
