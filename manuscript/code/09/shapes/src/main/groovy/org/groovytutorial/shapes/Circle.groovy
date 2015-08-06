package org.groovytutorial.shapes

import groovy.transform.ToString

import static java.lang.Math.PI

class Circle extends BasicTwoDimensionalShape {
    ;{
        shapeName = 'Circle'
    }

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
        "${super.getDisplayInfo()}: radius = $radius; diameter = $diameter; circumference = $circumference; area = $area"
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
