def determineAverage(...values)
        throws IllegalArgumentException, NullPointerException {
    for (item in values) {
        if (item instanceof String) {
            throw new IllegalArgumentException()
        }
    }
    return values.sum() / values.size()
}
