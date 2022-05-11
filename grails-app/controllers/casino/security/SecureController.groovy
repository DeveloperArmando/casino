package casino.security

import grails.transaction.Transactional

@Transactional(readOnly = true)
class SecureController {

    static responseFormats = ['json', 'xml']

    def index() {
        render 'Secure access only'
    }
}
