/**
 * Returns the average of the parameters
 *
 * @param values a series of numerical values
 * @throws IllegalArgumentException if a parameter is a String
 * @returns The average of the values
 */
def determineAverage(... values) {
    values.sum() / values.size()
}
