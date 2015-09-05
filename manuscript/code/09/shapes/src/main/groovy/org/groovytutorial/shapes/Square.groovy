package org.groovytutorial.shapes

class Square extends Rectangle {

    static final String SHAPE_NAME = 'Square'

    Square(Number length) {
        super(length, length)
    }
}
