package org.groovy_tutorial.shapes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Describes a rectangle
 *
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(includes = 'length,width')
@ToString(includeNames = true, includeFields = true, includePackage = true)
class Rectangle implements TwoDimensionalShape, Sides {

    private static final String SHAPE_NAME = 'Rectangle'

    /** The area of the rectangle */
    final BigDecimal area

    /**
     *
     * @param length
     * @param width
     * @throws IllegalArgumentException if one of the sides <= 0
     */
    Rectangle(Number length, Number width) throws IllegalArgumentException {
        a = length
        b = width
        c = length
        d = width

        //Calling this causes the Sides trait to calculate the perimeter
        //and lock off its sideMap
        this.perimeter

        this.area = length * width
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: length = $a; width = $b; perimeter = $perimeter; area = $area"
    }

    @Override
    String getShapeName() {
        SHAPE_NAME
    }
}
