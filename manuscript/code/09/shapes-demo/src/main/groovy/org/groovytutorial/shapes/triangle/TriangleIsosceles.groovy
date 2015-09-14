package org.groovytutorial.shapes.triangle

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import org.groovytutorial.shapes.Triangle

/**
 * A triangle with two sides of equal length
 *
 * @see <a href="https://en.wikipedia.org/wiki/Isosceles_triangle">Wikipedia - Isosceles triangle</a>
 */
@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
class TriangleIsosceles extends Triangle {
    static final String TRIANGLE_TYPE = 'Isosceles'

    TriangleIsosceles(Number sideA, Number sideB) {
        super(sideA, sideB, sideB)
    }

    @Override
    Number getArea() {
        def height = Math.sqrt(this.sides.b**2 - (this.sides.a**2 / 4))
        sides.a * (height / 2)
    }

    @Override
    String getDisplayInfo() {
        "$TRIANGLE_TYPE ${super.getDisplayInfo()}"
    }
}
