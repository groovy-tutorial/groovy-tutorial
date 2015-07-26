class Record {
    final List authors

    Record(List authors) {
        this.authors = authors
    }
}

Record myRec = new Record([ 'Jim', 'Sally' ])
println myRec.dump()

myRec.authors << 'Duncan'
println myRec.dump()
