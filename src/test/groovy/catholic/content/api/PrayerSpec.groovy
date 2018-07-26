package catholic.content.api

import grails.test.hibernate.HibernateSpec


class PrayerSpec extends HibernateSpec {

    def setup() {
    }

    def cleanup() {
    }

    void "test domain class validation"() {
        when:
        Prayer prayer = new Prayer(name: '')
        prayer.save()

        then:
        prayer.hasErrors()
        prayer.errors.getFieldError('name')
        prayer.errors.getFieldError('lang')
        prayer.errors.getFieldError('text')
        prayer.errors.getFieldError('slug')
        Prayer.count() == 0
    }
}
