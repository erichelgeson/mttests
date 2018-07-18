package mttests

import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.multitenancy.WithoutTenant
import grails.gorm.transactions.ReadOnly

@ReadOnly
class TenantService {

    def books() {
        Book.list()
    }

    @CurrentTenant
    def booksCurrentTenant() {
        Book.list()
    }

    @WithoutTenant
    def booksWithoutTenant() {
        Book.list()
    }
}
