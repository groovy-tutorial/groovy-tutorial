/**
 * Returns the average of the parameters
 *
 * @param values a series of numerical values
 * @returns The average of the values
 */
def determineAverage(... values) {
    values.sum() / values.size()
}
