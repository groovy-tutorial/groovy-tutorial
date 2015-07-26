class Record {
    final List authors

    Record() {
        authors = [ ].asImmutable()
    }

    Record(List authors) {
        this.authors = authors.asImmutable()
    }
}

Record myRec = new Record([ 'Jim', 'Sally' ])
println myRec.dump()

// This will fail with a java.lang.UnsupportedOperationException
myRec.authors << 'Duncan'
println myRec.dump()
