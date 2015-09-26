package org.groovy_tutorial.shapes.triangle

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.util.logging.Log
import org.groovy_tutorial.shapes.ShapeUtil

/**
 * A triangle with three equal sides
 *
 * @see <a href="https://en.wikipedia.org/wiki/Equilateral_triangle">Wikipedia - Equilateral triangle</a>
 *
 * @author Duncan Dickinson
 */
@Log
@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
final class TriangleEquilateral extends TriangleIsosceles {

    static final String TRIANGLE_TYPE = 'Equilateral'

    /**
     *
     * @param a
     * @throws IllegalArgumentException if a <= 0
     */
    TriangleEquilateral(Number a) throws IllegalArgumentException {
        super(a, a)
    }

    /**
     * Determines the area of this triangle.
     * In this implementation we call the static calculateArea(a) method
     * @return the area
     */
    @Override
    protected BigDecimal calculateArea() {
        calculateArea(a)
    }

    /**
     * Calculates the area of an equilateral triangle
     * @param a the edge (side) length
     * @return the area
     * @see <a href="https://en.wikipedia.org/wiki/Equilateral_triangle#Derivation_of_area_formula">Wikipedia article</a>
     * @throws IllegalArgumentException if a <= 0
     */
    static BigDecimal calculateArea(Number a) throws IllegalArgumentException {
        log.info "TriangleEquilateral.calculateArea was called with a=$a"
        ShapeUtil.checkSidesException(a)
        (Math.sqrt(3) / 4) * a**2
    }

    @Override
    String getDisplayInfo() {
        "$TRIANGLE_TYPE ${super.displayInfo}"
    }
}

