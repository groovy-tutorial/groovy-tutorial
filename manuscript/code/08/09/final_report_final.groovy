import groovy.transform.ToString

@ToString(includeNames = true)
class FinalReport {
    final List records

    FinalReport(List records) {
        this.records = records.asImmutable()
    }
}

@ToString(includeNames = true)
class Record {
    final Date creationDate = new Date()
    final String title
    final String text

    Record(String title, String text) {
        this.title = title
        this.text = text
    }
}

def recordSet = [
        [ 'Record A', 'This is a record' ] as Record,
        [ 'Record B', 'This is another record' ] as Record,
        [ 'Record C', 'This is yet another record' ] as Record
]

FinalReport report = new FinalReport(recordSet)

//This will fail with groovy.lang.ReadOnlyPropertyException
try {
    report.records[1].text = 'REDACTED'
} catch (ReadOnlyPropertyException e) {
    println 'Sorry, you can\'t change a record in a final report'
}

//This will fail with java.lang.UnsupportedOperationException
try {
    report.records << new Record('Record Z', 'You just go hacked')
} catch (UnsupportedOperationException e) {
    println 'Sorry, you can\'t add a record to a final report'
}

println report
