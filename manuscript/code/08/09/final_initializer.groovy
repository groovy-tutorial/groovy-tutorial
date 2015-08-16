class Record {
    static final String OWNER

    static {
        owner = 'Secret Corp'
    }

    final GregorianCalendar creationDate

    ;{
        creationDate = new GregorianCalendar()
    }
}

Record myRecord = new Record()
