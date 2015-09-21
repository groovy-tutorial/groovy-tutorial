package org.groovytutorial.shapes

/**
 * An interface for basic two-dimensional objects
 *
 * @see <a href="https://en.wikipedia.org/wiki/List_of_two-dimensional_geometric_shapes">
 *     Wikipedia: List of two-dimensional geometric shapes</a>
 *
 * @author Duncan Dickinson
 */
interface TwoDimensionalShape {

    /**
     * The length of the path surrounding a 2D shape
     * @see <a href="https://en.wikipedia.org/wiki/Perimeter">Wikipedia: Perimeter</a>
     * @return the perimeter of the shape
     */
    BigDecimal getPerimeter()

    /**
     * The extent of a 2D shape in a plane
     * @see <a href="https://en.wikipedia.org/wiki/Area">Wikipedia: Area</a>
     * @return the area of the shape
     */
    BigDecimal getArea()

    /**
     * A handy display string
     * @return a text representation of the shape
     */
    String getDisplayInfo()

    /**
     * @return the name of the shape
     */
    String getShapeName()
}
