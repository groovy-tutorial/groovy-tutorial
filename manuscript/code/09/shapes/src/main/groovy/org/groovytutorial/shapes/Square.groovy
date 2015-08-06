package org.groovytutorial.shapes

import groovy.transform.ToString

class Square extends Rectangle {
    ;{
        shapeName = 'Square'
    }

    Square(Number length) {
        super(length, length)
    }
}
