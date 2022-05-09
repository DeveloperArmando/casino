grails {
    mongodb {
        host = 'localhost'
        port = '27017'
    }
}

// It's to desactivate the version in the documents
grails.mongodb.default.mapping = {
    version false
}
