package org.groovytutorial.shapes

import static java.math.MathContext.DECIMAL32 as MC

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CircleAreaTest extends Specification {
    def "test calculateArea: a circle with radius of #radius has an area of #area"() {
        expect: "that the area is calculated correctly"
        area.round(MC) == Circle.calculateArea(radius).round(MC)

        where:
        radius || area
        2      || 12.56637061435917
        11     || 380.13271108436495
        0.1    || 0.0314159265359
    }

    def "test calculateArea throws an IllegalArgumentException exception when radius parameter (#radius) is <= 0"() {
        when: "the radius passed to calculateArea <= 0"
        Circle.calculateArea(radius)

        then: "An IllegalArgumentException is thrown"
        thrown(IllegalArgumentException)

        where:
        radius || _
        0      || _
        -11     || _
        -0.1    || _
    }
}
