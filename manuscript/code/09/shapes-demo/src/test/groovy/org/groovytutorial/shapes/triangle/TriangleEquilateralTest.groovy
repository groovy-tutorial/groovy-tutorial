package org.groovytutorial.shapes.triangle

import static java.math.MathContext.DECIMAL32 as MC

import org.groovytutorial.shapes.Triangle
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(TriangleEquilateral)
class TriangleEquilateralTest extends Specification {

    def "Ensure that the shapeName property == 'Triangle'"() {
        given: "A new Triangle"
        TriangleEquilateral t = new TriangleEquilateral(1)
        expect:
        'Triangle' == t.shapeName
    }

    def "Ensure that the triangleType property == 'Equilateral'"() {
        given: "A new Triangle"
        TriangleEquilateral t = new TriangleEquilateral(1)
        expect:
        'Equilateral' == t.triangleType
    }

    def "Test that an Equilateral Triangle of side (#a) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Equilateral Triangle"
        TriangleEquilateral t = new TriangleEquilateral(a)
        expect: "that the perimeter and area calculations are correct"
        t.a == a
        t.b == a
        t.c == a
        t.perimeter.round(MC) == perimeter.round(MC)
        t.area.round(MC) == area.round(MC)
        where: "the dimensions and resulting measurements are"
        a || perimeter | area
        3 || 9.0g | 3.89711431702998g
        7.2 || 21.6g | 22.44738g
    }
}
