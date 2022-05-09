import grails.util.Environment

switch (Environment.current.name) {
    case "development":
        grails {
            mongodb {
                host = 'localhost'
                port = '27017'
                databaseName = 'casino'
            }
        }
        break
    case "test":
        grails {
            mongodb {
                host = 'localhost'
                port = '27017'
                databaseName = 'casino'
            }
        }
        break
    case "demo":
        grails {
            mongodb {
                host = 'localhost'
                port = '27017'
                databaseName = 'casino'
            }
        }
        break
    case "production":
        grails {
            mongodb {
                host = 'localhost'
                port = '27017'
                databaseName = 'casino'
            }
        }
        break
}


// It's to desactivate the version in the documents
grails.mongodb.default.mapping = {
    version false
}
