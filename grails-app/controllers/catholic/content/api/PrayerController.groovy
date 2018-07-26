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
