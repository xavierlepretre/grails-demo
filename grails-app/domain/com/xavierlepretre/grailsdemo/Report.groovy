package com.xavierlepretre.grailsdemo

class Report {

    static belongsTo = [author: User]

    static constraints = {
    }

    static mapping = {
    }

    /**
     * This name will depend on the position of the report in the collection of reports
     * of the user.
     * As such, if report_1 is deleted, then report_2 will be renamed into report_1.
     * @return
     */
    String getReportName() {
        def name = "report_" + getPosition()
        if (author.locale.equals(new Locale("fr", "FR"))) {
            return new Rot13Util().redundanceFreeRot13(name)
        }
        return name
    }

    int getPosition() {
        return author.reports.indexOf(this) + 1;
    }
}
