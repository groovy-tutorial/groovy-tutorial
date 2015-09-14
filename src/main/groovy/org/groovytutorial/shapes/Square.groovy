package org.groovytutorial.shapes

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(callSuper = true)
@ToString(includeNames = true, includeFields = true, includePackage = true, includeSuper = true)
final class Square extends Rectangle {

    static final String SHAPE_NAME = 'Square'

    Square(Number length) {
        super(length, length)
    }

    @Override
    String getDisplayInfo() {
        "$SHAPE_NAME: length = ${sides.a}; perimeter = $perimeter; area = $area"
    }
}
