def determineAverage(...values)
        throws IllegalArgumentException {
    for (item in values) {
        if (item in String) {
            throw new IllegalArgumentException()
        }
    }

    if (!values) {
        return 0
    }

    values.sum() / values.size()
}

assert determineAverage() == 0
