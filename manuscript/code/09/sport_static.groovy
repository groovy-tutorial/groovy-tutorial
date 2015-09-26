trait Running {
    static final MAX_DISTANCE = 10_000

    static public final MAX_COMPETITORS = 12

    static describeRules() {
        println 'Here are the rules of running....'
    }
}

class SportingEvent implements Running {

}

assert SportingEvent.MAX_DISTANCE == 10_000

assert SportingEvent.Running__MAX_COMPETITORS == 12

SportingEvent.describeRules()
