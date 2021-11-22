package delegatebinding

import grails.converters.JSON

class TestController {

    def index(Person person) { 
        render(person as JSON)
    }
}
