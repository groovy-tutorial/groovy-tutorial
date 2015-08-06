package org.groovytutorial.shapes

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, includeSuper = true)
class Triangle extends BasicTwoDimensionalShape {

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

    @Override
    protected void calculateArea() {
        //See Wikipedia - Heron's Formula: https://en.wikipedia.org/wiki/Heron%27s_formula

        Number a, b, c
        (a, b, c) = [sides.a, sides.b, sides.c]

        Number s = (a + b + c) / 2

        area = Math.sqrt(s * (s - a) * (s - b) * (s - c))
    }

}
