package catholic.content.api

import grails.compiler.GrailsCompileStatic

@GrailsCompileStatic
class Prayer {

    String name
    String lang
    String text
    String slug
    String imgSrc

    static constraints = {
        name maxSize: 255
        lang maxSize: 255
        text type: 'text'
        imgSrc nullable: true, maxSize: 1000
    }
}
