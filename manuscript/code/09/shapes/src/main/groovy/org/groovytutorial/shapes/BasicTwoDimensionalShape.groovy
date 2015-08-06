package org.groovytutorial.shapes

import groovy.transform.ToString

abstract class BasicTwoDimensionalShape implements TwoDimensionalShape {

    protected String shapeName = ''

    protected Number perimeter = null

    protected Number area = null

    abstract protected void calculatePerimeter()

    abstract protected void calculateArea()

    @Override
    Number getPerimeter() {
        if (!perimeter) {
            calculatePerimeter()
        }
        perimeter
    }

    @Override
    Number getArea() {
        if (!area) {
            calculateArea()
        }
        area
    }

    @Override
    String getDisplayInfo() {
        return "$shapeName"
    }
}
