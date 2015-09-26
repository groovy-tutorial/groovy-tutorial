package org.groovy_tutorial.shapes.triangle

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.util.logging.Log
import org.groovy_tutorial.shapes.ShapeUtil
import org.groovy_tutorial.shapes.Triangle

/**
 * A triangle made famous by Pythagoras
 *
 * @author Duncan Dickinson
 */
@Log
@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
final class TriangleRightAngled extends Triangle implements TriangleSubtype {
    static final String TRIANGLE_TYPE = 'Right-angled'

    /**
     * Tell us the "other sides" and the hypotenuse will be determined for you!
     * @param a one of the "other sides"
     * @param b one of the "other sides"
     * @throws IllegalArgumentException if one of the sides <= 0
     */
    TriangleRightAngled(Number a, Number b) throws IllegalArgumentException {
        super(a, b, calculateHypotenuse(a, b))
    }

    /**
     * Determines the area of this triangle.
     * In this implementation we call the static calculateArea(a, b) method
     * @return the area
     */
    @Override
    protected BigDecimal calculateArea() {
        calculateArea(a, b)
    }

    /**
     * Determine a right-angled triangle's hypotenuse using Pythagoras' theorem
     * @param a
     * @param b
     * @return the hypotenuse
     * @throws IllegalArgumentException if a or b <= 0
     */
    static Number calculateHypotenuse(Number a, Number b) throws IllegalArgumentException {
        ShapeUtil.checkSidesException(a, b)
        Math.sqrt(a**2 + b**2)
    }

    /**
     * Uses 0.5 * a * b
     * @param a
     * @param b
     * @return the area
     * @throws IllegalArgumentException if a or b <= 0
     */
    static Number calculateArea(Number a, Number b) throws IllegalArgumentException {
        log.info "TriangleRightAngled.calculateArea was called with a=$a, b=$b"
        ShapeUtil.checkSidesException(a, b)
        0.5 * a * b
    }

    @Override
    String getDisplayInfo() {
        "$TRIANGLE_TYPE ${super.displayInfo}"
    }
}
