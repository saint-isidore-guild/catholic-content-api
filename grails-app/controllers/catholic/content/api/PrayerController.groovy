package catholic.content.api

import grails.rest.*
import groovy.transform.CompileStatic

@CompileStatic
class PrayerController extends RestfulController {
	static responseFormats = ['json', 'xml']

    PrayerService prayerService

    PrayerController() {
        super(Prayer)
    }

    def search(PrayerSearchCmd cmd) {
        respond prayerService.search(cmd)
    }

}

class PrayerSearchCmd {
    String q
    String lang
    String slug
    Integer max = 100

    static constraints = {
        q nullable: true
        lang nullable: true
        slug nullable: true
        max nullable: true
    }
}
