package org.groovytutorial.shapes

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(Square)
class SquareTest extends Specification {

    def "Ensure that SHAPE_NAME is 'Square'"() {
        expect:
        'Square' == Square.SHAPE_NAME
    }

    def "Test that a Square of length #length has a perimeter of #perimeter and an area of #area"() {
        given: "A new Square"
        Square s = new Square(length)

        expect: "that the fields are set correctly"
        s.a == length
        s.b == length
        s.c == length
        s.d == length
        s.perimeter == perimeter
        s.area == area

        where: "the dimensions and resulting measurements are"
        length || perimeter | area
        2 || 8 | 4
        10 || 40 | 100
        6 || 24 | 36
        10.1 || 40.4 | 102.01
    }

    def "Ensure that a square can only be defined with a positive numeric length (#length)"() {
        when: "A square is set up with a bad length"
        Square s = new Square(length)

        then: "Expect one of two exceptions"
        thrown(IllegalArgumentException)

        where: "the dimensions and resulting measurements are"
        length   | _
        0        | _
        -2       | _
        -10      | _
        -6       | _
    }

}
