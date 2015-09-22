def determineAverage(...values) throws IllegalArgumentException {
    for (item in values) {
        if (item in String) {
            throw new IllegalArgumentException()
        }
    }
    return values.sum() / values.size()
}

//This works:
assert determineAverage(12, 18) == 15

//This does not work - we get an exception
determineAverage(5, 5, 8, 'kitten')
