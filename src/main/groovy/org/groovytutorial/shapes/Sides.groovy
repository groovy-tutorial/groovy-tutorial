package org.groovytutorial.shapes

/**
 * A basic trait describing the outer edges (sides) of a 2D shapes
 *
 * @author Duncan Dickinson
 */
trait Sides {
    Map sides = [:]
    Number perimeter = null

    /**
     * Calculates the perimeter of the shape
     * @return the sum of the sides
     */
    Number getPerimeter() {
        if (!perimeter) {
            perimeter = sides.values().sum()
        }
        perimeter
    }

    private void setPerimeter(Number p){
        getPerimeter()
    }

    private void setSides(Map sides) throws UnsupportedOperationException{
        throw new UnsupportedOperationException()
    }
}
