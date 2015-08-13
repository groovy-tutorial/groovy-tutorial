import groovy.transform.Immutable
import groovy.transform.ToString

@ToString(includeNames = true)
@Immutable
class FinalReport {
    final List records
}

@ToString(includeNames = true)
@Immutable
class Record {
    Date creationDate = new Date()
    String title
    String text
}

def recordSet = [
        new Record(title: 'Record A', text: 'This is a record'),
        new Record(title: 'Record B', text: 'This is another record'),
        new Record(title: 'Record C', text: 'This is yet another record')
]

FinalReport report = new FinalReport(recordSet)

//This will fail with groovy.lang.ReadOnlyPropertyException
report.records[1].text = 'REDACTED'
