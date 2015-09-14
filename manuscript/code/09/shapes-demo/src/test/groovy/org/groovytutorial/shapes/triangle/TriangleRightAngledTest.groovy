package org.groovytutorial.shapes.triangle

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(TriangleRightAngled)
class TriangleRightAngledTest extends Specification {
    def "Test that a Right Angled Triangle of sides (#sideA, #sideB) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Right Angled Triangle"
        TriangleRightAngled t = new TriangleRightAngled(sideA, sideB)
        expect: "that the perimeter and area calculations are correct"
        t.perimeter == perimeter
        t.area == area
        where: "the dimensions and resulting measurements are"
        sideA | sideB || perimeter | area
        3 | 4 || 12 | 6
    }
}
