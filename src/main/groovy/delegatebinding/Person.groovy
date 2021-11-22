package delegatebinding

import grails.validation.Validateable

class Person implements Validateable {
    String first
    String last
    
    @Delegate 
    Address address = new Address()
    
    static constraints = {
        street bindable: true
        zip bindable: true
        city bindable: true
    }
}
