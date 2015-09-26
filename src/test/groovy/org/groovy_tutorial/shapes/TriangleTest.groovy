package org.groovy_tutorial.shapes

import static java.math.MathContext.DECIMAL32 as MC

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(Triangle)
class TriangleTest extends Specification {

    def "Ensure that SHAPE_NAME is 'Triangle'"() {
        expect:
        'Triangle' == Triangle.SHAPE_NAME
    }

    def "Ensure that the shapeName property == 'Triangle'"() {
        given: "A new Triangle"
        Triangle t = new Triangle(1, 1, 1)
        expect:
        'Triangle' == t.shapeName
    }

    def "Test that a Triangle of sides (#a, #b, #c) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Triangle"
        Triangle t = new Triangle(a, b, c)

        expect: "that the perimeter and area calculations are correct"
        t.a == a
        t.b == b
        t.c == c
        t.perimeter.round(MC) == perimeter.round(MC)
        t.area.round(MC) == area.round(MC)

        where: "the dimensions and resulting measurements are"
        a | b | c || perimeter | area
        3 | 4 | 5 || 12.0g | 6.0g
        3 | 3 | 3 || 9.0g | 3.89711431702998g

    }

}
