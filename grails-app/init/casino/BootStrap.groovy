package casino

class BootStrap {

    def init = { servletContext ->
        createObjectTest()
    }
    def destroy = {
    }

    def createObjectTest() {
        new Book(nombre: "Principito").save(flush: true)
    }
}
