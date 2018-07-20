package mttests

import grails.converters.JSON
import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.multitenancy.WithoutTenant

class CurrentController {

    def tenantService

    @CurrentTenant
    def with() {
        render Book.list() as JSON // Returns only current tenants books as expected
    }

    /*
        Returns only current tenants books without any annotations - unexpected.
        due to `MultiTenantEventListener`
     */
    def none() {
        render Book.list() as JSON
    }

    @WithoutTenant
    def without() {
        render Book.list() as JSON // Returns all Tenants books as expected
    }

    /*
        WithoutTenant on Controller
        CurrentTenant on Service
        Expect it to only return CurrentTenants books, but returns all tenants books.
     */
    @WithoutTenant
    def serviceWith() {
        // Service with @CurrentTenant on method
        def books = tenantService.booksCurrentTenant()

        // but returns all anyways!
        render books as JSON
    }

    @WithoutTenant
    def serviceWithout() { // behaves same as serviceWith
        // Service with @WithoutTenant on method
        def books = tenantService.booksWithoutTenant()

        // returns all
        render books as JSON
    }
}