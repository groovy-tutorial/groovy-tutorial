class Record {
    final Date creationDate = new Date()
}

Record myRec = new Record()

//This will fail with a groovy.lang.ReadOnlyPropertyException
myRec.creationDate = new Date()
