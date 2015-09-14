package org.groovytutorial.shapes

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(Rectangle)
class RectangleTest extends Specification {
    def "Test that a rectangle of length #length and width #width has a perimeter of #perimeter and an area of #area"() {
        given: "A new rectangle"
        Rectangle r = new Rectangle(length, width)

        expect: "that the fields are set correctly"
        r.length == length
        r.width == width
        r.perimeter == perimeter
        r.area == area

        where: "the dimensions and resulting measurements are"
        length  | width || perimeter | area
        2       | 2     || 8         | 4
        10      | 7     || 34        | 70
        6       | 100   || 212       | 600
    }
}
