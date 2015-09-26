trait Running {

    Integer distance

    public String raceType = 'foot race event'

    private Integer maxCompetitors = 10

    void startEvent() {
        println 'Ready, set, go!'
    }

}

class SportingEvent implements Running {
    String name

    String describeEvent() {
        "This is a ${Running__raceType} for ${Running__maxCompetitors} competitors"
    }
}

SportingEvent dash = new SportingEvent()

assert dash.Running__raceType == 'foot race event'
assert dash.Running__maxCompetitors == 10

dash.Running__maxCompetitors = 99
assert dash.Running__maxCompetitors == 99

println dash.describeEvent()
