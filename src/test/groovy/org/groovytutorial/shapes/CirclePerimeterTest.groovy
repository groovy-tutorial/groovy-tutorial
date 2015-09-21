package org.groovytutorial.shapes

import static java.math.MathContext.DECIMAL32 as MC

import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class CirclePerimeterTest extends Specification {
    def "test calculatePerimeter: a circle with radius of #radius has a perimeter of #perimeter"() {
        expect: "that the perimter is calculated correctly"
        perimeter.round(MC) == Circle.calculatePerimeter(radius).round(MC)

        where:
        radius || perimeter
        2      || 12.56637061435918
        11     || 69.11503837897545
        0.1    || 0.62831853071796
    }

    def "test calculatePerimeter throws an IllegalArgumentException exception when radius parameter (#radius) is <= 0"() {
        when: "the radius passed to calculatePerimeter <= 0"
        Circle.calculatePerimeter(radius)

        then: "An IllegalArgumentException is thrown"
        thrown(IllegalArgumentException)

        where:
        radius || _
        0      || _
        -11     || _
        -0.1    || _
    }
}
