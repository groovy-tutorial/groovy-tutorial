# Final 

Before we move on from properties and fields, let's just look at one more item

{title='',lang=groovy}

	class Record {
	    final Date creationDate = new Date()
	}
	
	Record myRec = new Record()
	
	//This will fail:
	myRec.creationDate = new Date()

`groovy.lang.ReadOnlyPropertyException`

{title='',lang=groovy}

	class Record {
	    final Date creationDate
	    
	    Record() {
	        this.creationDate = new Date()
	    }
	    
	    Record(Date created){
	        this.creationDate = created
	    }
	}
	
	Record myRec = new Record()
	Record myOtherRec = new Record(new Date())

But for collections....

{title='',lang=groovy}
	
	class Record {
	    final List authors
	    
	    Record(List authors) {
	        this.authors = authors
	    }
	}
	
	Record myRec = new Record(['Jim', 'Sally'])
	println myRec.dump()
	
	myRec.authors << 'Duncan'
	println myRec.dump()
	
This will stop Duncan:

{title='',lang=groovy}
	
	class Record {
	    final List authors
	    
	    Record() {
     	   authors = [].asImmutable()
    	}
    	
	    Record(List authors) {
	        this.authors = authors.asImmutable()
	    }
	}
	
	Record myRec = new Record(['Jim', 'Sally'])
	println myRec.dump()
	
	myRec.authors << 'Duncan'
	println myRec.dump()

