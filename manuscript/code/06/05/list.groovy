def buyGroceries(store, items) {
    println "I'm off to $store to buy:"
    for (item in items) {
        println "  -$item"
    }
}

buyGroceries 'The Corner Store', ['apples', 'cat food', 'cream']
