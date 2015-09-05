package org.groovytutorial.shapes

import static java.lang.Math.PI

/**
 *
 */
class Circle extends BasicTwoDimensionalShape {
    static final String SHAPE_NAME = 'Circle'

    final Number radius
    final Number diameter

    Circle(Number radius) {
        this.radius = radius
        this.diameter = this.radius * 2
    }

    @Override
    protected void calculatePerimeter() {
        this.perimeter = this.diameter * PI
    }

    @Override
    protected void calculateArea() {
        this.area = this.radius**2 * PI
    }

    @Override
    String getDisplayInfo() {
        "${super.displayInfo}: radius = $radius; diameter = $diameter; circumference = ${circumference.trunc(4)}; area = ${area.trunc(4)}"
    }

    Number getRadius() {
        radius
    }

    Number getDiameter() {
        diameter
    }

    /**
     * Just a convenience - equivalent to getPerimeter
     * @return the circumference
     */
    Number getCircumference() {
        perimeter
    }
}
