package org.groovy_tutorial.shapes

import static java.math.MathContext.DECIMAL32 as MC
import org.groovy_tutorial.shapes.triangle.TriangleEquilateral
import org.groovy_tutorial.shapes.triangle.TriangleIsosceles
import org.groovy_tutorial.shapes.triangle.TriangleRightAngled
import spock.lang.Specification
import spock.lang.Unroll

@Unroll
class TriangleAreaTest extends Specification {
    def "test that calculateArea returns the same value (#area) for triangles (a=#a) in the equilateral lineage"() {
        when:
        BigDecimal calculatedArea = Triangle.calculateArea(a, a, a).round(MC)

        then:
        area.round(MC) == calculatedArea
        calculatedArea == TriangleEquilateral.calculateArea(a).round(MC)
        calculatedArea == TriangleIsosceles.calculateArea(a, a).round(MC)

        where: "the dimensions and resulting measurements are"
        a || area
        3 || 3.89711431702998
    }

    def "test that calculateArea returns the same value (#area) for triangles  (base=#a, legs=#b) in the isosceles lineage"() {
        when:
        BigDecimal calculatedArea = Triangle.calculateArea(a, b, b).round(MC)

        then:
        area.round(MC) == calculatedArea
        calculatedArea == TriangleIsosceles.calculateArea(a, b).round(MC)

        where: "the dimensions and resulting measurements are"
        a | b || area
        3 | 8 || 11.787175234126
    }

    def "test that calculateArea returns the same value (#area) for triangles (a=#a, b=#b) in the right angled lineage"() {
        when:
        BigDecimal calculatedArea = Triangle
                .calculateArea(a, b, TriangleRightAngled.calculateHypotenuse(a, b))
                .round(MC)

        then:
        area.round(MC) == calculatedArea
        calculatedArea == TriangleRightAngled.calculateArea(a, b).round(MC)

        where: "the dimensions and resulting measurements are"
        a | b || area
        3 | 4 || 6.0g
    }
}
