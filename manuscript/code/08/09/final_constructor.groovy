class Record {
    final Date creationDate

    Record() {
        this.creationDate = new Date()
    }

    Record(Date created) {
        this.creationDate = created
    }
}

Record myRec = new Record()
Record myOtherRec = new Record(new Date())

println myRec.dump()
println myOtherRec.dump()
