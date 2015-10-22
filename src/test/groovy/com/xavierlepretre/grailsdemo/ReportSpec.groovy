package com.xavierlepretre.grailsdemo

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Report)
class ReportSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test report name conventional"() {
        setup:
        def john = new User(name: "John", locale: new Locale("en", "US"), reports: [])
        def report1 = new Report(author: john)
        john.reports.add(report1)
        def report2 = new Report(author: john)
        john.reports.add(report2)

        expect:"Report name badly formed"
        report1.reportName == "report_1"
        report2.reportName == "report_2"
    }

    void "test report name rot13"() {
        setup:
        def jean = new User(name: "Jean", locale: new Locale("fr", "FR"), reports: [])
        def report1 = new Report(author: jean)
        jean.reports.add(report1)
        def report2 = new Report(author: jean)
        jean.reports.add(report2)

        expect:"Report name badly formed"
        report1.reportName == "ercbeg_1"
        report2.reportName == "ercbeg_2"
    }
}
