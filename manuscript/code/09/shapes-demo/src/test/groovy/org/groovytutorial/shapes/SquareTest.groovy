package org.groovytutorial.shapes

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(Square)
class SquareTest extends Specification {
    def "Test that a Square of length #length has a perimeter of #perimeter and an area of #area"() {
        given: "A new Square"
        Square s = new Square(length)

        expect: "that the fields are set correctly"
        s.length == length
        s.length == s.width
        s.perimeter == perimeter
        s.area == area

        where: "the dimensions and resulting measurements are"
        length || perimeter | area
        2 || 8 | 4
        10 || 40 | 100
        6 || 24 | 36
        10.1 || 40.4 | 102.01
    }

}
