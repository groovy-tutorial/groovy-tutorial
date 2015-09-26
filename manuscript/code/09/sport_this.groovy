trait Running {
    Integer distance

    void setDistance(distance) {
        if (distance > 10_000) {
            throw new IllegalArgumentException('Surely you can\'t run that far')
        }
        this.distance = distance
    }
}

class SportingEvent implements Running {
    String name

    def getAdvert() {
        "${this.name} is a ${this.distance}m event"
    }
}

SportingEvent groovySprint = new SportingEvent(name: 'The Groovy 500', distance: 500)
println groovySprint.advert
