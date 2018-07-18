package mttests

import grails.converters.JSON

/*
 This Controller and Service have no tenant concepts, though queries are filter on the CurrentTenant
*/
class NotawareController {

    def tenantService

    def index() {
        render Book.list() as JSON
    }

    def service() {
        render tenantService.books() as JSON
    }
}