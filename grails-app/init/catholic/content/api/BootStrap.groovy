package catholic.content.api

class BootStrap {

    def init = { servletContext ->

        new Prayer(name: 'Our Father', lang: 'eng', slug: 'ourfather', text: """Our Father who art in heaven,
Hallowed be thy name.
Thy kingdom come.
Thy will be done
on earth as it is in heaven.
Give us this day our daily bread,
and forgive us our trespasses,
as we forgive those who trespass against us,
and lead us not into temptation,
but deliver us from evil.
""").save(flush: true, failOnError: true)

        new Prayer(name: 'Pater Noster', lang: 'ltn', slug: 'ourfather', text: """Pater noster, qui es in caelis:
sanctificetur nomen tuum;
adveniat regnum tuum;
fiat voluntas tua, sicut in caelo, et in terra.
Panem nostrum cotidianum da nobis hodie;
et dimitte nobis debita nostra,
sicut et nos dimittimus debitoribus nostris;
et ne nos inducas in tentationem;
sed libera nos a malo.
""", imgSrc: 'https://en.wikipedia.org/wiki/Lord%27s_Prayer#/media/File:Pater_Noster_in_Cantus_Planus.png').save(flush: true, failOnError: true)

    }
    def destroy = {
    }
}
