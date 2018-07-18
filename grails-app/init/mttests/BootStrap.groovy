package mttests

import static grails.gorm.multitenancy.Tenants.withId

class BootStrap {

    def init = { servletContext ->
        Book.withNewTransaction {
            withId ("1") {
                new Book(name: 'Book 1 Tenant').save(failOnError: true, flush:true)
            }
            withId ("2") {
                new Book(name: 'Book 2 Tenant').save(failOnError: true, flush:true)
            }
        }
    }
    def destroy = {
    }
}
