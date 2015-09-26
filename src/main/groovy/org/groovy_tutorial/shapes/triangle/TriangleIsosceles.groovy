package org.groovy_tutorial.shapes.triangle

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.util.logging.Log
import org.groovy_tutorial.shapes.ShapeUtil
import org.groovy_tutorial.shapes.Triangle

/**
 * A triangle with two sides of equal length
 *
 * @see <a href="https://en.wikipedia.org/wiki/Isosceles_triangle">Wikipedia - Isosceles triangle</a>
 *
 * @author Duncan Dickinson
 */
@Log
@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
class TriangleIsosceles extends Triangle implements TriangleSubtype  {
    protected static String TRIANGLE_TYPE =  'Isosceles'

    /**
     * Create a triangle that has one base side and two equal sides (legs)
     * @param a the base
     * @param b the leg(s)
     * @throws IllegalArgumentException if one of the sides <= 0
     */
    TriangleIsosceles(Number base, Number leg) throws IllegalArgumentException {
        super(base, leg, leg)
    }

    /**
     * Determines the area of this triangle.
     * In this implementation we call the static calculateArea(a, b) method
     * @return
     */
    @Override
    protected BigDecimal calculateArea() {
        calculateArea(a, b)
    }

    /**
     * Calculates the area of an isosceles triangle using a simplified version of Heron's formula
     * @param base the base
     * @param leg the leg(s)
     * @return
     * @see <a href="https://en.wikipedia.org/wiki/Isosceles_triangle#Area">Wikipedia article</a>
     * @throws IllegalArgumentException if base or leg <= 0
     */
    static final BigDecimal calculateArea(Number base, Number leg) throws IllegalArgumentException {
        log.info "TriangleIsosceles.calculateArea was called with base=$base, b=$leg"
        ShapeUtil.checkSidesException(base, leg)
        def height = Math.sqrt(leg**2 - (base**2 / 4))
        base * (height / 2)
    }

    @Override
    String getDisplayInfo() {
        "$TRIANGLE_TYPE ${super.displayInfo}"
    }
}
