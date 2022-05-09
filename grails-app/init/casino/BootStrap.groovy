package casino

class BootStrap {

    def init = { servletContext ->
        createObjectTest()
    }
    def destroy = {
    }

    def createObjectTest() {
        if (!Book.findByNombre("Principito"))
            new Book(nombre: "Principito").save(flush: true)
    }
}
