package org.groovytutorial.shapes

class Rectangle extends BasicTwoDimensionalShape {

    static final String SHAPE_NAME = 'Rectangle'

    final Number length
    final Number width

    /**
     * The default constructor - not useful
     */
    private Rectangle() {

    }

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
        "${super.displayInfo}: length = $length; width = $width; perimeter = $perimeter; area = $area"
    }

    Number getLength() {
        length
    }

    Number getWidth() {
        width
    }
}
