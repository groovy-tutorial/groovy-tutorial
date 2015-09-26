import groovy.transform.SelfType

@SelfType(SportingEvent)
trait Running {
    Integer distance

    void setDistance(distance) {
        if (distance > 10_000) {
            throw new IllegalArgumentException('Surely you can\'t run that far')
        }
        this.distance = distance
    }

    def getAdvert() {
        "${this.name} is a ${this.distance}m event"
    }
}

class SportingEvent implements Running {
    String name
}
