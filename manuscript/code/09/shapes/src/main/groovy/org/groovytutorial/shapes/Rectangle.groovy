package org.groovytutorial.shapes

import groovy.transform.ToString

class Rectangle extends BasicTwoDimensionalShape {
    ;{
        shapeName = 'Rectangle'
    }

    final Number length
    final Number width

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

    @Override
    String getDisplayInfo() {
        "${super.getDisplayInfo()}: length = $length; width = $width; perimeter = $perimeter; area = $area"
    }

    Number getLength() {
        length
    }

    Number getWidth() {
        width
    }
}
