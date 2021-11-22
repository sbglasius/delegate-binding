package delegatebinding

import grails.validation.Validateable

class Address implements Validateable {
    String street
    String zip
    String city
}
