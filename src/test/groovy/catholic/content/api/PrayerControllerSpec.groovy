package catholic.content.api

import grails.test.hibernate.HibernateSpec
import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class PrayerControllerSpec extends HibernateSpec implements ControllerUnitTest<PrayerController> {

    def prayerService
    def ourFather

    def setup() {
        ourFather = new Prayer(name: 'Our Father', slug: 'ourfather', text: "Our Father...", lang: 'eng').save(flush: true, failOnError:true)

        prayerService = Mock(PrayerService)
        controller.prayerService = prayerService
    }

    def cleanup() {
    }

    void "search"() {
        when:
        controller.search()

        then:
        1 * prayerService.search(_) >> [ourFather]
        response.json.size() == 1
        response.json[0].name == 'Our Father'
    }
}