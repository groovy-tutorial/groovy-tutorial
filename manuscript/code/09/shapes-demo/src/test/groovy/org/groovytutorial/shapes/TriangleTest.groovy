package org.groovytutorial.shapes

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(Triangle)
class TriangleTest extends Specification {
    def "Test that a Triangle of sides (#sideA, #sideB, #sideC) has a perimeter of #perimeter and an area of #area"() {
        given: "A new Triangle"
        Triangle t = new Triangle(sideA, sideB, sideC)

        expect: "that the perimeter and area calculations are correct"
        t.perimeter == perimeter
        t.area.trunc(4) == area

        where: "the dimensions and resulting measurements are"
        sideA | sideB | sideC || perimeter | area
        3 | 4 | 5 || 12 | 6
        3 | 3 | 3 || 9 | 3.8971

    }

}
