package delegateBinding

import delegatebinding.Person
import grails.web.databinding.DataBindingUtils
import spock.lang.Specification

class DelegateBindingSpec extends Specification {

    void "test binding with delegate"() {
        given:
        def bindingSource = [first: 'Søren', last: 'Glasius', street: 'Hedevej 1', zip: '8680', city: 'Ry']
        
        def person = new Person()
        
        when:
        DataBindingUtils.bindObjectToInstance(person, bindingSource)
        
        and:
        person.validate()
        
        then:
        !person.hasErrors()     
    }
}
