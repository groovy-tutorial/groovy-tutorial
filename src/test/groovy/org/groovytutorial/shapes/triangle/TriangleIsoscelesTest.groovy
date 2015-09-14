package org.groovytutorial.shapes.triangle

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(TriangleIsosceles)
class TriangleIsoscelesTest extends Specification {
    def "Test that an Isosceles Triangle of sides (#sideA, #sideB) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Isosceles Triangle"
        TriangleIsosceles t = new TriangleIsosceles(sideA, sideB)
        expect: "that the perimeter and area calculations are correct"
        t.perimeter == perimeter
        t.area.trunc(4) == area
        where: "the dimensions and resulting measurements are"
        sideA | sideB || perimeter | area
        4.0 | 5.0 || 14.0 | 9.1651

    }

}
