/*
 * An example
 *
 * Please refer to the HyperSQL documentation for details regarding that product:
 *   http://hsqldb.org/doc/2.0/guide/index.html
 */

@GrabConfig(systemClassLoader=true)
@Grab(group='org.hsqldb', module='hsqldb', version='2.3.2')
import groovy.sql.Sql

def createSchema = '''
CREATE TABLE temperatures (
    value DECIMAL(4,2)
)
'''

def dropSchema = '''
DROP TABLE IF EXISTS temperatures
'''

def sql

def db = [url: 'jdbc:hsqldb:mem:temperatures', 
          user: 'sa', 
          password: '', 
          driver: 'org.hsqldb.jdbc.JDBCDriver']

try { 
    //Connect to the database         
    sql = Sql.newInstance(db)
} catch (java.sql.SQLException sqlex) {
    println "Exception connecting to database: ${sqlex.getMessage()}"
    return 1
}

//Run the DROP TABLE command
sql.execute(dropSchema)

try {
    //Create the 
    sql.execute(createSchema)
} catch (java.sql.SQLException sqlex) {
    println "Exception creating table: ${sqlex.getMessage()}"
    return 1
}


def temps = sql.dataSet("temperatures")

try {
    sql.withTransaction {
        [10.2, 6.8, 8.9].each {
            temps.add(value: it)
        }
    }
} catch (java.sql.SQLException sqlex) {
    println "Exception creating table: ${sqlex.getMessage()}"
    return 1
}

print temps.rows()

sql.close()