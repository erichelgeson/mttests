package mttests

import grails.gorm.MultiTenant

class Book implements MultiTenant<Book> {

    String tenantId // because a system property is always a String
    String name

    static constraints = {
    }
}
