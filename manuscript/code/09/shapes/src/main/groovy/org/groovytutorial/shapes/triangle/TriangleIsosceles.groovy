package org.groovytutorial.shapes.triangle

import org.groovytutorial.shapes.Triangle

class TriangleIsosceles extends Triangle {

    TriangleIsosceles(Number sideA, Number sideB) {
        super(sideA, sideB, sideB)
    }

    @Override
    protected void calculateArea() {
        Number height = Math.sqrt(this.sides.b**2 - (this.sides.a**2 / 4))
        area = sides.a * (height / 2)
    }
}
