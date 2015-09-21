package org.groovytutorial.shapes

/**
 * A basic trait describing the outer edges (sides) of a 2D shape.
 *
 * This trait uses the missingProperty method to allow implementations
 * to define sides using lower case characters (e.g. a, b, c). These properties must:
 * <ul>
 *     <li>Be a single, lower-case character (matching Sides.SIDE_NAME_PATTERN)</li>
 *     <li>Be only assigned a positive numeric value</li>
 * </ul>
 *
 * Once getPerimeter is called, the sides map is locked down and can't be modified.
 *
 * @author Duncan Dickinson
 */
trait Sides {
    /** Defines the acceptable naming strategy for sides */
    static final SIDE_NAME_PATTERN = /[a-z]/

    /** Used to hold the named list of sides */
    private final Map sideMap = [ : ]

    /** The perimeter, as determined by the sum of the sides */
    private BigDecimal perimeter = null

    /**
     * Calculates the perimeter of the shape (once).
     * After calling this method, the sides are locked down and you can't add or edit them
     * via propertyMissing
     * @return the sum of the sideMap (the perimeter)
     */
    BigDecimal getPerimeter() {
        perimeter = perimeter ?:sideMap.values().sum().toBigDecimal()
    }

    /**
     * @return a CLONE of the sideMap
     */
    Map getSideMap() {
        sideMap.clone() as Map
    }

    /**
     * Gets the value for a named side
     * @param name the name of the side (e.g. a, b, c)
     * @return the value of the side
     * @throws MissingPropertyException if name not found
     */
    def propertyMissing(String name) throws MissingPropertyException {
        if (name.matches(SIDE_NAME_PATTERN)) {
            return sideMap.get(name)
        }

        throw new MissingPropertyException("Property $name not found")
    }

    /**
     * Sets the length (value) for a named side
     * @param name the name of the side
     * @param value the length of the side
     * @return the value back to the caller
     * @throws ReadOnlyPropertyException if the perimeter has been calculated
     * @throws IllegalArgumentException if the value <= 0
     * @throws MissingPropertyException if name doesn't match SIDE_NAME_PATTERN
     */
    def propertyMissing(String name, value)
            throws ReadOnlyPropertyException, IllegalArgumentException, MissingPropertyException {
        if (name.matches(SIDE_NAME_PATTERN)) {
            if (perimeter) {
                throw new ReadOnlyPropertyException(name, Sides)
            }
            if (value instanceof Number) {
                ShapeUtil.checkSidesException(value)
                sideMap.put(name, value as Number)
                return sideMap.get(name)
            }
            throw new IllegalArgumentException("The value [$value] is not a positive number.")
        }
        throw new MissingPropertyException("Property $name not found")
    }
}
