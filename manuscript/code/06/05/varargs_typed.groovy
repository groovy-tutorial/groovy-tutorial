def buyGroceries(String... items) {
    for (item in items) {
        println item
    }
}

buyGroceries 'apples', 'cat food', 'cream'
