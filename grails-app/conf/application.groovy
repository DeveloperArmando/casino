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


// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'casino.security.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'casino.security.UserRole'
grails.plugin.springsecurity.authority.className = 'casino.security.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
        [pattern: '/', access: ['permitAll']],
        [pattern: '/error', access: ['permitAll']],
        [pattern: '/index', access: ['permitAll']],
        [pattern: '/index.gsp', access: ['permitAll']],
        [pattern: '/shutdown', access: ['permitAll']],
        [pattern: '/assets/**', access: ['permitAll']],
        [pattern: '/**/js/**', access: ['permitAll']],
        [pattern: '/**/css/**', access: ['permitAll']],
        [pattern: '/**/images/**', access: ['permitAll']],
        [pattern: '/**/favicon.ico', access: ['permitAll']],
]

grails.plugin.springsecurity.filterChain.chainMap = [
        [pattern: '/assets/**', filters: 'none'],
        [pattern: '/**/js/**', filters: 'none'],
        [pattern: '/**/css/**', filters: 'none'],
        [pattern: '/**/images/**', filters: 'none'],
        [pattern: '/**/favicon.ico', filters: 'none'],
        [
                pattern: '/api/guest/**',
                filters: 'none'
        ],
        [
                pattern: '/api/**',
                filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
        ],
        [
                pattern: '/**',
                filters: 'JOINED_FILTERS,-anonymousAuthenticationFilter,-exceptionTranslationFilter,-authenticationProcessingFilter,-securityContextPersistenceFilter,-rememberMeAuthenticationFilter'
        ],


]

//grails.plugin.springsecurity.rest.token.storage.jwt.expiration = 30
grails.plugin.springsecurity.rest.token.storage.jwt.useSignedJwt = true
grails.plugin.springsecurity.rest.token.storage.jwt.secret = "sjqmYrhT7hK4yFCzbWCpJ2jHWy36bCO2Ccp"

grails.plugin.springsecurity.rest.login.usernamePropertyName = "usuario"
grails.plugin.springsecurity.rest.login.passwordPropertyName = "contra"
grails.plugin.springsecurity.rest.token.validation.enableAnonymousAccess = true
