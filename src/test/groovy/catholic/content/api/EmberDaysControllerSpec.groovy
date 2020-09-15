package catholic.content.api

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

import java.time.LocalDate

class EmberDaysControllerSpec extends Specification implements ControllerUnitTest<EmberDaysController> {

    def setup() {
    }

    def cleanup() {
    }

    void "fall"() {
        when:
        def fall = controller.calculateFall(2020)

        then:
        fall == LocalDate.of(2020, 9, 16)
    }

    void "winter"() {
        when:
        def winter = controller.calculateWinter(2020)

        then:
        winter == LocalDate.of(2020, 12, 16)
    }

    void "summer"() {
        when:
        def summer = controller.calculateSummer(2020)

        then:
        summer == LocalDate.of(2020, 6, 3)
    }

    void "spring in leap year"() {
        when:
        def spring = controller.calculateSpring(2020)

        then:
        spring == LocalDate.of(2020, 3, 4)
    }

    void "spring in non-leap year"() {
        when:
        def spring = controller.calculateSpring(2021)

        then:
        spring == LocalDate.of(2021, 2, 24)
    }
}