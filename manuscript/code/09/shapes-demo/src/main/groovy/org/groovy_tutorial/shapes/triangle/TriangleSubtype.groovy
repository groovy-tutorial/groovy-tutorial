package org.groovy_tutorial.shapes.triangle

import groovy.transform.SelfType
import org.groovy_tutorial.shapes.Triangle

/**
 * A basic example of a targeted trait
 *
 * @author Duncan Dickinson
 */
@SelfType(Triangle)
trait TriangleSubtype {

    /**
     * Expects that implementations provide a value for the TRIANGLE_TYPE String
     * @return a String representing the type of triangle
     */
    String getTriangleType() {
        TRIANGLE_TYPE
    }
}
