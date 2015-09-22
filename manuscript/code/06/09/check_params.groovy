/**
 * Returns the average of the parameters
 *
 * @param values  a series of numerical values
 * @throws IllegalArgumentException if a parameter is a String
 * @returns The average of the values
 */
def determineAverage(...values)
        throws IllegalArgumentException {
    for (item in values) {
        if (item in String) {
            throw new IllegalArgumentException()
        }
    }
    values.sum() / values.size()
}

//This works:
assert determineAverage(12, 18) == 15

//This does not work - we get an exception
determineAverage(5, 5, 8, 'kitten')
