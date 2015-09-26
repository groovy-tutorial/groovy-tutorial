package org.groovy_tutorial.shapes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Describes a square
 *
 * @author Duncan Dickinson
 */
@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
final class Square extends Rectangle {

    private static final String SHAPE_NAME = 'Square'

    /**
     * @param length
     * @throws IllegalArgumentException if one of the sides <= 0
     */
    Square(Number length) throws IllegalArgumentException {
        super(length, length)
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: length = ${a}; perimeter = $perimeter; area = $area"
    }
}
