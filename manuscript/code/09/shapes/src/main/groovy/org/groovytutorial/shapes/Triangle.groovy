package org.groovytutorial.shapes

/**
 *
 */
class Triangle extends BasicTwoDimensionalShape {
    static final String SHAPE_NAME = 'Triangle'
    static final String TRIANGLE_TYPE = 'Generic'

    final Map sides

    Triangle(Number sideA, Number sideB, Number sideC) {
        sides = [ a: sideA,
                  b: sideB,
                  c: sideC ].asImmutable()
    }

    Map getSides() {
        sides
    }

    @Override
    protected void calculatePerimeter() {
        Number sum = 0

        for (Number side in sides.values()) {
            sum += side
        }
        perimeter = sum
    }

    /**
     * Uses Heron's formula to determine the area of the Triangle
     *
     * @see <a href="https://en.wikipedia.org/wiki/Heron%27s_formula">Wikipedia - Heron's Formula</a>
     */
    @Override
    protected void calculateArea() {

        Number a, b, c
        (a, b, c) = [ sides.a, sides.b, sides.c ]

        Number s = (a + b + c) / 2

        area = Math.sqrt(s * (s - a) * (s - b) * (s - c))
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME - $TRIANGLE_TYPE: Side A = ${sides.a}; Side B = ${sides.b}; Side C = ${sides.c}; perimeter = $perimeter; area = ${area}"
    }
}
