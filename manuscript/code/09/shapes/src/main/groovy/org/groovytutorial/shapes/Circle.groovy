package org.groovytutorial.shapes

import groovy.transform.ToString

import static java.lang.Math.PI

@ToString(includeNames = true, includeFields = true, includeSuper = true)
class Circle extends BasicTwoDimensionalShape {

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

    Number getRadius() {
        radius
    }

    Number getDiameter() {
        diameter
    }

    Number getCircumference() {
        perimeter
    }
}
