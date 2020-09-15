package catholic.content.api


import java.time.DayOfWeek
import java.time.LocalDate
import java.time.Month

class EmberDaysController {
	static responseFormats = ['json', 'xml']
	
    def index() {
        LocalDate date =  LocalDate.now()
        emberDaysByYear(date.year)
    }

    def year(Long year) {
        emberDaysByYear(year)
    }

    private Map emberDaysByYear(Long year) {
        Map emberDays = [winter: calculateWinter(year), spring: calculateSpring(year), summer: calculateSummer(year), fall: calculateFall(year)]
        emberDays
    }

    /**
     * https://dzone.com/articles/algorithm-calculating-date
     * https://en.wikipedia.org/wiki/Computus#Anonymous_Gregorian_algorithm
     *
     * @param year
     * @return
     */
    private LocalDate lookupEaster(Long year) {
        int Y = year;
        int a = Y % 19;
        int b = Y / 100;
        int c = Y % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int L = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * L) / 451;
        int month = (h + L - 7 * m + 114) / 31;
        int day = ((h + L - 7 * m + 114) % 31) + 1;
        LocalDate.of(year.toInteger(), month, day)
    }

    private LocalDate calculateFall(Long year) {
        LocalDate exaltationOfTheCross = LocalDate.of(year.toInteger(), Month.SEPTEMBER, 14)
        findNextWednesdayAfterDate(exaltationOfTheCross)
    }

    private LocalDate calculateWinter(Long year) {
        LocalDate saintLucy = LocalDate.of(year.toInteger(), Month.DECEMBER, 13)
        findNextWednesdayAfterDate(saintLucy)
    }

    private LocalDate calculateSummer(Long year) {
        LocalDate easter = lookupEaster(year)
        easter.plusDays(49 + 3) // Wednesday after Pentecost
    }

    private LocalDate calculateSpring(Long year) {
        LocalDate easter = lookupEaster(year)
        easter.minusDays(46 - 7) // week after Ash Wednesday
    }

    private static LocalDate findNextWednesdayAfterDate(LocalDate localDate) {
        while (localDate.dayOfWeek != DayOfWeek.WEDNESDAY) {
            localDate = localDate.plusDays(1)
        }
        return localDate
    }
}
