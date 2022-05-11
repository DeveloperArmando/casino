package casino.security

import grails.plugin.springsecurity.SpringSecurityService
import grails.plugin.springsecurity.annotation.Secured
import grails.plugin.springsecurity.userdetails.GrailsUser
import groovy.transform.CompileStatic

@CompileStatic
@Secured('isAuthenticated()')
class HelloController {
    static responseFormats = ['json']

    SpringSecurityService springSecurityService

    def index() {
        [name: loggedUsername()]
    }

    String loggedUsername() {
        if (springSecurityService.principal == null) {
            println("case null")
            return null
        }
        if (springSecurityService.principal instanceof String) {
            println("principal sttring")
            return springSecurityService.principal
        }
        if (springSecurityService.principal instanceof GrailsUser) {
            println("GrailsUser ${springSecurityService.currentUser}")
            return ((GrailsUser) springSecurityService.principal).username
        }
        null
    }
}
