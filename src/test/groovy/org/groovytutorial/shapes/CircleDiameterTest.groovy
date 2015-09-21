package org.groovytutorial.shapes

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CircleDiameterTest extends Specification {
    def "test calculateDiameter: a circle with radius of #radius has a diameter of #diameter"() {
        expect: "that the diameter is twice the radius"
        diameter == Circle.calculateDiameter(radius)

        where:
        radius || diameter
        2      || 4
        11     || 22
        0.1    || 0.2
    }

    def "test calculateDiameter throws an IllegalArgumentException exception when radius parameter (#radius) is <= 0"() {
        when: "the radius passed to calculateDiameter <= 0"
        Circle.calculateDiameter(radius)

        then: "An IllegalArgumentException is thrown"
        thrown(IllegalArgumentException)

        where:
        radius || _
        0      || _
        -11     || _
        -0.1    || _
    }
}
