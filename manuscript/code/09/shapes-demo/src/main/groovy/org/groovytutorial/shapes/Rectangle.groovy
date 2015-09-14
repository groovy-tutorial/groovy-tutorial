package org.groovytutorial.shapes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes = 'length,width')
@ToString(includeNames = true, includeFields = true, includePackage = true)
class Rectangle implements TwoDimensionalShape, Sides {

    static final String SHAPE_NAME = 'Rectangle'

    final Number area

    Rectangle(Number length, Number width) {
        sides.a = length
        sides.b = width
        sides.c = length
        sides.d = width
        this.area = sides.a * sides.b
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: length = ${sides.a}; width = ${sides.b}; perimeter = $perimeter; area = $area"
    }
}
