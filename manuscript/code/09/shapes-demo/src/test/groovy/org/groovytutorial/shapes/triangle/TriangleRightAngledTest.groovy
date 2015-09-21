package org.groovytutorial.shapes.triangle

import static java.math.MathContext.DECIMAL32 as MC
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(TriangleRightAngled)
class TriangleRightAngledTest extends Specification {

    def "Ensure that the shapeName property == 'Triangle'"() {
        given: "A new Triangle"
        TriangleRightAngled t = new TriangleRightAngled(3, 4)
        expect:
        'Triangle' == t.shapeName
    }

    def "Ensure that the triangleType property == 'Right-angled'"() {
        given: "A new Triangle"
        TriangleRightAngled t = new TriangleRightAngled(3, 4)
        expect:
        'Right-angled' == t.triangleType
    }

    def "Test that a Right Angled Triangle of sides (#a, #b) has an hypotenuse of #hypotenuse, a perimeter of #perimeter and an area of #area"() {
        given: "A new Right Angled Triangle"
        TriangleRightAngled t = new TriangleRightAngled(a, b)
        expect: "that the perimeter and area calculations are correct"
        t.a == a
        t.b == b
        t.c == hypotenuse
        t.perimeter.round(MC) == perimeter.round(MC)
        t.area.round(MC) == area.round(MC)
        where: "the dimensions and resulting measurements are"
        a | b || hypotenuse | perimeter | area
        3 | 4 || 5 | 12.0g | 6.0g
    }
}
