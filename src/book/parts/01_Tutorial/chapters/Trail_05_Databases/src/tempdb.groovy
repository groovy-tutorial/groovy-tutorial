@GrabConfig(systemClassLoader=true)
@Grab(group='org.hsqldb', module='hsqldb', version='2.3.2')

import groovy.sql.Sql


def create_table = '''
CREATE TABLE temperatures (
    value DECIMAL(4,2)
)
'''

def clear_db = '''
DROP TABLE temperatures
'''

def db = [url: 'jdbc:hsqldb:mem:temperatures', 
          user: 'sa', 
          password: '', 
          driver: 'org.hsqldb.jdbc.JDBCDriver']

def sql

try {          
    sql = Sql.newInstance(db.url, db.user, db.password, db.driver)
} catch (java.sql.SQLException sqlex) {
    println "Exception connecting to database: ${sqlex.getMessage()}"
    return 1
}

try {
    sql.execute(clear_db)
} catch (java.sql.SQLException sqlex) {
    //Ignore
}

try {
    sql.execute(create_table)
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