package org.groovytutorial.shapes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Describes a generic triangle.
 *
 * For more specific types, use a class from {@link org.groovytutorial.shapes.triangle}
 */
@EqualsAndHashCode(includes = 'sides')
@ToString(includeNames = true, includeFields = true, includePackage = true)
class Triangle implements TwoDimensionalShape, Sides {
    static final String SHAPE_NAME = 'Triangle'

    Triangle(Number sideA, Number sideB, Number sideC) {
        sides.a = sideA
        sides.b = sideB
        sides.c = sideC
    }

    /**
     * Uses Heron's formula to determine the area of the Triangle
     *
     * @see <a href="https://en.wikipedia.org/wiki/Heron%27s_formula">Wikipedia - Heron's Formula</a>
     */
    static calculateHeronsFormula(Number sideA, Number sideB, Number sideC){
        Number s = (sideA + sideB + sideC) / 2
        Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC))
    }

    @Override
    Number getArea() {
        calculateHeronsFormula(sides.a, sides.b, sides.c)
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: Side A = ${sides.a}; Side B = ${sides.b}; Side C = ${sides.c}; perimeter = $perimeter; area = ${area}"
    }
}
