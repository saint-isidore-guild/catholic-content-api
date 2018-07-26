package catholic.content.api

import grails.gorm.transactions.ReadOnly
import grails.gorm.transactions.Transactional

@Transactional
class PrayerService {

    @ReadOnly
    List<Prayer> search(PrayerSearchCmd cmd) {
        List prayers = []
        List results = Prayer.createCriteria().list(max: cmd?.max ?: 10) {
            if (cmd?.q) {
                ilike('name', "%${cmd?.q}%")
            }
            if (cmd?.slug) {
                eq('slug', cmd?.slug)
            }
            if (cmd?.lang) {
                eq('lang', cmd?.lang)
            }
        } as List<Prayer>
        prayers.addAll(results)
        if (!cmd?.lang) {
            results.each {
                prayers.addAll(Prayer.findAllBySlug(it.slug))
            }
        }
        prayers.unique()
    }

}
