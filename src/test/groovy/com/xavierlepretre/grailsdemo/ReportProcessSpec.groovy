package com.xavierlepretre.grailsdemo

import spock.lang.Specification

class ReportProcessSpec extends Specification {

    void "startedAt cannot be null"() {
        when:
        new ReportProcess(null, new User(name: "John", locale: new Locale("th")))

        then:
        thrown(IllegalArgumentException)
    }

    void "author cannot be null"() {
        when:
        new ReportProcess(new Date(), null)

        then:
        thrown(IllegalArgumentException)
    }

    void "isDone not immediately"() {
        setup:
        def process = new ReportProcess(new Date(), new User(name: "John", locale: new Locale("th")))

        expect:
        !process.isDone()
    }

    void "isDone when long enough"() {
        setup:
        def process = new ReportProcess(new Date(0), new User(name: "John", locale: new Locale("vn")))

        expect:
        process.isDone()
    }

    void "isDone when passed exactly"() {
        setup:
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MILLISECOND, - ReportProcess.MILLISEC_DURATION)
        def process = new ReportProcess(calendar.getTime(), new User(name: "John", locale: new Locale("vn")))

        expect:
        process.isDone()
    }
}
