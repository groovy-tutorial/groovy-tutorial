class Record {
    static final String OWNER = 'Secret Corp'

    final Calendar creationDate

    Record() {
        creationDate = new GregorianCalendar()
    }

    Record(GregorianCalendar created) {
        creationDate = created
    }
}

Record record1 = new Record()

GregorianCalendar created = new GregorianCalendar(2015, 5, 4)
Record record2 = new Record(created)
