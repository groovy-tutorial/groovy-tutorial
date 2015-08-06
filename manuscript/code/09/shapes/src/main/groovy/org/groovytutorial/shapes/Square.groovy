package org.groovytutorial.shapes

import groovy.transform.ToString

@ToString(includeNames = true, includeFields = true, includeSuper = true)
class Square extends Rectangle {

    Square(Number length) {
        super(length, length)
    }
}
