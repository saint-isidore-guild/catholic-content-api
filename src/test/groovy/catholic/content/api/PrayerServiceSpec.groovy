package catholic.content.api

import grails.test.hibernate.HibernateSpec
import grails.testing.services.ServiceUnitTest

class PrayerServiceSpec extends HibernateSpec implements ServiceUnitTest<PrayerService>{

    def setup() {
        new Prayer(name: 'Our Father', slug: 'ourfather', text: "Our Father...", lang: 'eng').save(flush: true, failOnError:true)
        new Prayer(name: 'Pater Noster', slug: 'ourfather', text: "Pater noster...", lang: 'lat').save(flush: true, failOnError:true)
        new Prayer(name: 'Hail Mary', slug: 'hailmary', text: "Hail Mary...", lang: 'eng').save(flush: true, failOnError:true)
        new Prayer(name: 'Ave Maria', slug: 'hailmary', text: "Ave Maria...", lang: 'lat').save(flush: true, failOnError:true)
    }

    void "search"() {
        given:
        PrayerSearchCmd cmd = new PrayerSearchCmd()

        when:
        def results = service.search(cmd)

        then:
        results.size() == 4

        when:"name search for 'our'"
        cmd.q = 'our'
        results = service.search(cmd)

        then:
        results.size() == 2

        when:"name search for 'ave' in Latin language"
        cmd.q = 'ave'
        cmd.lang = 'lat'
        results = service.search(cmd)

        then:
        results.size() == 1
    }
}
