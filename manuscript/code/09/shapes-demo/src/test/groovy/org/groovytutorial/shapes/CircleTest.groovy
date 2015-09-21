package org.groovytutorial.shapes

import static java.math.MathContext.DECIMAL32 as MC
import spock.lang.Specification
import spock.lang.Subject
import spock.lang.Unroll

@Unroll
@Subject(Circle)
class CircleTest extends Specification {

    def "Ensure that SHAPE_NAME is 'Circle"() {
        expect:
        'Circle' == Circle.SHAPE_NAME
    }

    def "Circle of radius #radius has a diameter of #diameter, a perimeter of #perimeter and an area of #area"() {
        given: "A new Circle"
        Circle r = new Circle(radius)

        expect: "that the fields are set correctly"
        r.radius == radius
        r.diameter == radius * 2
        r.perimeter.round(MC) == perimeter.round(MC)
        r.perimeter.round(MC) == r.circumference.round(MC)
        r.area.round(MC) == area.round(MC)
        //"Circle: radius = $radius; diameter = $diameter; circumference = $perimeter; area = $area" ==
        //        r.displayInfo

        where: "the dimensions and resulting measurements are"
        radius || diameter | perimeter | area
        2 || 4 | 12.56637g | 12.56637g
        10 || 20 | 62.83185g | 314.1593g
        6 || 12 | 37.69911g | 113.0973g
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

    def "Ensure that a circle can only be defined with a positive numeric radius"() {
        when: "A rectangle is set up with a bad length and/or width"
        Circle r = new Circle(radius)

        then: "Expect one of two exceptions"
        thrown(IllegalArgumentException)

        where: "the dimensions and resulting measurements are"
        radius || _
        -2 || _
        -6 || _
    }
}
