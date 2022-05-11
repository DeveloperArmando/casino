package casino

import casino.security.Role
import casino.security.User
import casino.security.UserRole

class BootStrap {

    def init = { servletContext ->
        createRolesAndUsers()
        createProducts()
    }
    def destroy = {
    }

    def createRolesAndUsers() {
        def adminRole = Role.findByAuthority('ROLE_ADMIN')
        if (!adminRole)
            adminRole = new Role(authority: 'ROLE_ADMIN').save()
        if (!Role.findByAuthority('ROLE_CAJERO'))
            new Role(authority: 'ROLE_CAJERO').save()

        def testUser = User.findByUsername("me")
        if (!testUser)
            testUser = new User(username: 'me', password: 'password').save()

        if (!UserRole.exists(testUser.id, adminRole.id))
            UserRole.create testUser, adminRole

        UserRole.withSession {
            it.flush()
            it.clear()
        }

//        assert User.count() == 1
//        assert Role.count() == 1
//        assert UserRole.count() == 1
    }

    def createProducts() {
        if (!Product.findByProdName("iPhone 7"))
            new Product(prodName: "iPhone 7", prodDesc: "New iPhone 7 32GB", prodPrice: 780).save flush: true
        if (!Product.findByProdName("iPhone 7 Plus"))
            new Product(prodName: "iPhone 7 Plus", prodDesc: "New iPhone 7 Plus 128GB", prodPrice: 990).save flush: true
        if (!Product.findByProdName("iPhone 7 SE"))
            new Product(prodName: "iPhone 7 SE", prodDesc: "New iPhone 7 SE 64GB", prodPrice: 520).save flush: true
    }
}
