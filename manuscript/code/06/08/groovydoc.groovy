/**
 * Returns the average of the parameters
 *
 * @param values  a series of numerical values
 * @throws IllegalArgumentException if a values parameter is a String
 * @returns The average of the values
 */
def determineAverage(...values)
        throws IllegalArgumentException {
    for (item in values) {
        if (item in String) {
            throw new IllegalArgumentException()
        }
    }
    return values.sum() / values.size()
}
