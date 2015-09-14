package org.groovytutorial.shapes

import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(Circle)
class CircleTest extends Specification {

    def "Test that Circle.calculateDiameter returns #result for a radius of #radius"(){
        expect:
        result == Circle.calculateDiameter(radius)

        where:
        radius || result
        2 || 4
        10 || 20
        6 || 12
    }

    def "Test that Circle.calculatePerimeter returns #result for a radius of #radius"(){
        expect:
        result == Circle.calculatePerimeter(radius).trunc(4)

        where:
        radius || result
        2 || 12.5663
        10 || 62.8318
        6 || 37.6991
    }

    def "Test that Circle.calculateArea returns #result for a radius of #radius"(){
        expect:
        result == Circle.calculateArea(radius).trunc(4)

        where:
        radius || result
        2 || 12.5663
        10 || 314.1592
        6 || 113.0973
    }

    def "Ensure that equality check is correctly returning #result when a new Circle(#radius) is compared to #rhs"() {
        given: "A new Circle"
        Circle r = new Circle(radius)

        expect:
        result == (r == rhs)

        where:
        radius | rhs            || result
        2      | new Circle(2)  || true
        5      | new Circle(4)  || false
        10     | new Expando(radius: 10) || false
    }

    def "Test that a Circle of radius #radius has a diameter of #diameter, a perimeter of #perimeter and an area of #area"() {
        given: "A new Circle"
        Circle r = new Circle(radius)

        expect: "that the fields are set correctly"
        r.radius == radius
        r.diameter == radius * 2
        r.perimeter.trunc(4) == perimeter
        r.perimeter == r.circumference
        r.area.trunc(4) == area

        where: "the dimensions and resulting measurements are"
        radius || diameter | perimeter | area
        2 || 4 | 12.5663 | 12.5663
        10 || 20 | 62.8318 | 314.1592
        6 || 12 | 37.6991 | 113.0973
    }
}
