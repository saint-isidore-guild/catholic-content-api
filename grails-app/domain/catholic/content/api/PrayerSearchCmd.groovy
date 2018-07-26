package catholic.content.api

class PrayerSearchCmd {
    String q
    String lang
    String slug
    Integer max

    static constraints = {
        q nullable: true
        lang nullable: true
        slug nullable: true
        max nullable: true
    }
}
