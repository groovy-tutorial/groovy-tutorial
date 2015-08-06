package org.groovytutorial.shapes

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true)
abstract class BasicTwoDimensionalShape implements TwoDimensionalShape {

    protected Number perimeter = null

    protected Number area = null

    abstract protected void calculatePerimeter()

    abstract protected void calculateArea()

    Number getPerimeter() {
        if (!perimeter) {
            calculatePerimeter()
        }
        perimeter
    }

    Number getArea() {
        if (!area) {
            calculateArea()
        }
        area
    }
}
