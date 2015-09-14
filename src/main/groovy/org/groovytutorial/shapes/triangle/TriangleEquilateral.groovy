package org.groovytutorial.shapes.triangle

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * A triangle with three equal sides
 *
 * @see <a href="https://en.wikipedia.org/wiki/Equilateral_triangle">Wikipedia - Equilateral triangle</a>
 */
@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
final class TriangleEquilateral extends TriangleIsosceles {
    static final String TRIANGLE_TYPE = 'Equilateral'

    TriangleEquilateral(Number sideA) {
        super(sideA, sideA)
    }

    @Override
    Number getArea() {
        Math.sqrt(3) / 4 * this.sides.a**2
    }

    @Override
    String getDisplayInfo() {
        "$TRIANGLE_TYPE ${super.getDisplayInfo()}"
    }
}

