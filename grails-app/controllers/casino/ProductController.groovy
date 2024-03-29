package casino

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional
import org.springframework.context.MessageSource
import org.springframework.context.i18n.LocaleContextHolder

import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
@Secured('isAuthenticated()')
class ProductController {

    static responseFormats = ['json', 'xml']
    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    MessageSource messageSource

    @Secured('ROLE_ADMIN')
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Product.list(params), model: [productCount: Product.count()]
    }

    def show(Product product) {
        respond product
    }

    @Transactional
    def save(Product product) {
        if (product == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (product.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond product.errors, view: 'create'
            return
        }

        product.save flush: true

        respond product, [status: CREATED, view: "show"]
    }

    @Transactional
    def update(Product product) {
        if (product == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        if (product.hasErrors()) {
            transactionStatus.setRollbackOnly()
            respond product.errors, view: 'edit'
            return
        }

        product.save flush: true

        respond product, [status: OK, view: "show"]
    }

    @Transactional
    def delete(Product product) {

        if (product == null) {
            transactionStatus.setRollbackOnly()
            render status: NOT_FOUND
            return
        }

        product.delete flush: true

        render status: NO_CONTENT
    }

    def test() {
        render "Si jala"
    }

    def testI18n() {
        def msg = messageSource.getMessage(
                'my.localized.content',
                ['Pepe', 'Miercoles'] as Object[],
                'Default Message',
                LocaleContextHolder.locale
        )
        render msg
    }
}
