package org.groovy_tutorial.shapes

/**
 * A general utility class
 *
 * @author Duncan Dickinson
 */
class ShapeUtil {

    /**
     * The shapes library supports sides of length > 0. This method helps check this.
     * @param sides a series of parameters, each reflecting a side's length
     * @return true if all sides are valid, false otherwise
     */
    static boolean checkSides(Number... sides) {
        for (side in sides) {
            if (side <= 0) {
                return false
            }
        }
        true
    }

    /**
     * Helper method - throws an exception if checkSides returns false
     * @param sides a series of parameters, each reflecting a side's length
     * @throws IllegalArgumentException if one of the sides <= 0
     */
    static void checkSidesException(Number... sides) throws IllegalArgumentException {
        if (!checkSides(sides)) {
            throw new IllegalArgumentException('The side must be a positive number.')
        }
    }
}
