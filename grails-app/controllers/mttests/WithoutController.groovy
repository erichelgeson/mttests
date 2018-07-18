package mttests

import grails.converters.JSON
import grails.gorm.multitenancy.WithoutTenant

@WithoutTenant
class WithoutController {

    def index() {
        render Book.list() as JSON
    }
}