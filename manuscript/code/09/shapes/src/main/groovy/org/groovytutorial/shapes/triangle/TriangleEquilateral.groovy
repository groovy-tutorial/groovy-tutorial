package org.groovytutorial.shapes.triangle

import org.groovytutorial.shapes.Triangle

class TriangleEquilateral extends Triangle {
    ;{
        shapeName = "Triangle - Equilateral"
    }

    TriangleEquilateral(Number sideA) {
        super(sideA, sideA, sideA)
    }

    @Override
    protected void calculateArea() {
        area = Math.sqrt(3) / 4 * this.sides.a**2
    }
}

