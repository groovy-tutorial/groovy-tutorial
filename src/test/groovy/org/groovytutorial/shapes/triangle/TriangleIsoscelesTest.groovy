package org.groovytutorial.shapes.triangle

import static java.math.MathContext.DECIMAL32 as MC
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(TriangleIsosceles)
class TriangleIsoscelesTest extends Specification {

    def "Ensure that the shapeName property == 'Triangle'"() {
        given: "A new Triangle"
        TriangleIsosceles t = new TriangleIsosceles(1, 2)
        expect:
        'Triangle' == t.shapeName
    }

    def "Ensure that the triangleType property == 'Isosceles'"() {
        given: "A new Triangle"
        TriangleIsosceles t = new TriangleIsosceles(1, 2)
        expect:
        'Isosceles' == t.triangleType
    }

    def "Test that an Isosceles Triangle of sides (#a, #b) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Isosceles Triangle"
        TriangleIsosceles t = new TriangleIsosceles(a, b)
        expect: "that the perimeter and area calculations are correct"
        t.a == a
        t.b == b
        t.c == b
        t.perimeter.round(MC) == perimeter.round(MC)
        t.area.round(MC) == area.round(MC)
        where: "the dimensions and resulting measurements are"
        a | b || perimeter | area
        4 | 5 || 14.0g | 9.165151g
        3 | 3 || 9.0g | 3.89711431702998g

    }

}
