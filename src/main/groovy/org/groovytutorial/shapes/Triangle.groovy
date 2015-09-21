package org.groovytutorial.shapes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.util.logging.Log

/**
 * Describes a generic triangle.
 *
 * For more specific types, use a class from {@link org.groovytutorial.shapes.triangle}
 *
 * @author Duncan Dickinson
 */
@Log
@EqualsAndHashCode(includes = 'sideMap')
@ToString(includeNames = true, includeFields = true, includePackage = true)
class Triangle implements TwoDimensionalShape, Sides {
    static final String SHAPE_NAME = 'Triangle'

    final BigDecimal area

    /**
     * Configures the sides (a, b, c) of the triangle and calls the perimeter property
     * of the Sides trait in order to make the sides (mostly) immutable and lock in
     * the perimeter calculation
     *
     * The protected calculateArea method is called to determine the area of the
     * triangle. The result is assigned to the <code>area</code> field.
     *
     * @param a One of the triangle's three sides
     * @param b One of the triangle's three sides
     * @param c One of the triangle's three sides
     * @throws IllegalArgumentException if one of the sides <= 0
     */
    Triangle(Number a, Number b, Number c) throws IllegalArgumentException {
        this.a = a
        this.b = b
        this.c = c

        //Calling this causes the Sides trait to calculate the perimeter
        //and lock off its sideMap
        this.perimeter
        this.area = calculateArea()
    }

    /**
     * Determines the area of this triangle.
     * In this implementation we call the static calculateArea(a, b, c) method
     *
     * Subclasses can override this method if they feel they're able to provide a
     * leaner calculation.
     *
     * @return the area
     */
    protected BigDecimal calculateArea() {
        calculateArea(a, b, c)
    }

    /**
     * Uses Heron's formula to determine the area of the Triangle
     *
     * @see <a href="https://en.wikipedia.org/wiki/Heron%27s_formula">Wikipedia - Heron's Formula</a>
     * @throws IllegalArgumentException if a, b or c are <= 0
     */
    static final BigDecimal calculateArea(Number a, Number b, Number c) throws IllegalArgumentException {
        log.info "Triangle.calculateArea was called with a=$a, b=$b, c=$c"
        ShapeUtil.checkSidesException(a, b, c)
        Number s = (a + b + c) / 2
        Math.sqrt(s * (s - a) * (s - b) * (s - c))
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: Side A = $a; Side B = $b; \
Side C = $c; perimeter = $perimeter; area = $area"
    }

    @Override
    String getShapeName() {
        SHAPE_NAME
    }
}
