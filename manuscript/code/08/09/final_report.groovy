import groovy.transform.Immutable
import groovy.transform.ToString

@ToString(includeNames = true)
class FinalReport {
    final List records

    FinalReport(List records) {
        this.records = records as Immutable
    }
}

@ToString(includeNames = true)
class Record {
    final Date creationDate = new Date()
    String title
    String text

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

report.records[1].text = 'REDACTED'

println report.records[1]
