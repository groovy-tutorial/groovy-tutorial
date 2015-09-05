package org.groovytutorial.shapes

/**
 * Provides a base abstract implementation for use by concrete 2D Shapes
 */
abstract class BasicTwoDimensionalShape implements TwoDimensionalShape {

    /** The textual name of the shape */
    abstract static final String SHAPE_NAME

    /** The perimeter of the shape */
    protected Number perimeter = null

    /** The area of the shape */
    protected Number area = null

    /**
     * Performs the perimeter calculation
     */
    abstract protected void calculatePerimeter()

    /**
     * Performs the area calculation
     */
    abstract protected void calculateArea()

    @Override
    Number getPerimeter() {
        // As the perimeter is derived from other fields we'll defer the calculation
        // to the concrete class through the calculatePerimeter method
        if (!perimeter) {
            calculatePerimeter()
        }
        perimeter
    }

    @Override
    Number getArea() {
        // As the area is derived from other fields we'll defer the calculation
        // to the concrete class through the calculateArea method
        if (!area) {
            calculateArea()
        }
        area
    }

    @Override
    String getDisplayInfo() {
        SHAPE_NAME
    }
}
