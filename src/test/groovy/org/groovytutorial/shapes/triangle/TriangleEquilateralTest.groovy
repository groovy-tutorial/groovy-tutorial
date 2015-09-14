package org.groovytutorial.shapes.triangle

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(TriangleEquilateral)
class TriangleEquilateralTest extends Specification {
    def "Test that an Equilateral Triangle of side (#sideA) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Equilateral Triangle"
        TriangleEquilateral t = new TriangleEquilateral(sideA)
        expect: "that the perimeter and area calculations are correct"
        t.perimeter == perimeter
        t.area.trunc(4) == area
        where: "the dimensions and resulting measurements are"
        sideA || perimeter | area
        3 || 9 | 3.8971
        7.2 || 21.6 | 22.4473

    }

}
