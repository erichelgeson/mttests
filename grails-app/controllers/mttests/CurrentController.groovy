package mttests

import grails.converters.JSON
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.multitenancy.WithoutTenant

class CurrentController {

    def tenantService

    @CurrentTenant
    def with() {
        render Book.list() as JSON
    }

    def none() { // Has the same results as with due to `MultiTenantEventListener`
        render Book.list() as JSON
    }

    @WithoutTenant
    def without() {
        render Book.list() as JSON
    }

    @WithoutTenant
    def serviceWith() {
        // with Tenant on service
        def books = tenantService.booksCurrentTenant()
        // but returns all anyways!
        render books as JSON
    }

    @WithoutTenant
    def serviceWithout() { // behaves same as serviceWith
        // with Tenant on service
        def books = tenantService.booksWithoutTenant()
        // but returns all anyways!
        render books as JSON
    }
}