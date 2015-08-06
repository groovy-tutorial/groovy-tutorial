package org.groovytutorial.shapes

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, includeSuper = true)
class Rectangle extends BasicTwoDimensionalShape {

    final Number length

    final Number width

    private x = 2

    Rectangle(Number length, Number width) throws IllegalArgumentException {
        this.length = length
        this.width = width
    }

    @Override
    protected void calculatePerimeter() {
        perimeter = (this.length + this.width) * 2
    }

    @Override
    protected void calculateArea() {
        area = this.length * this.width
    }

    Number getLength() {
        length
    }

    Number getWidth() {
        width
    }
}
