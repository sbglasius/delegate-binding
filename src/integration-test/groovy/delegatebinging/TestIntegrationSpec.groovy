package delegatebinging

import grails.testing.mixin.integration.Integration
import grails.testing.spock.OnceBefore
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import spock.lang.Specification

@Integration
class TestIntegrationSpec extends Specification {

    HttpClient client

    @OnceBefore
    void init() {
        String baseUrl = "http://localhost:$serverPort"
        this.client = HttpClient.create(baseUrl.toURL())
    }
    
    void "test delegateBinding"() {
        when:
        HttpResponse<Map> resp = client.toBlocking().exchange(HttpRequest.POST('/test', [first: 'Søren', last: 'Glasius', street: 'Hedevej 1', zip: '8680', city: 'Ry']), Map)
        
        then:
        resp.status == HttpStatus.OK
        with(resp.body()) {
            address.street == 'Hedevej 1'
            address.zip == '8680'
            address.city == 'Ry'
            first == 'Søren'
            last == 'Glasius'
        }
    }
}
