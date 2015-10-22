package com.xavierlepretre.grailsdemo

class ReportProcessCounterUtil {

    private static Collection<ReportProcess> reportProcesses = new ArrayList<ReportProcess>()

    static createProcess(User user) {
        reportProcesses.add(new ReportProcess(user))
    }

    static createReportsForDoneProcesses() {
        for (ReportProcess reportProcess : new ArrayList<>(reportProcesses)) {
            if (reportProcess == null) {
                reportProcesses.remove(reportProcess);
            } else if (reportProcess.isDone()) {
                Report report = new Report(author: reportProcess.author)
                report.save(flush: true)
                reportProcesses.remove(reportProcess)
            }
        }
    }

    static int countProcesses() {
        return reportProcesses.size()
    }

    static int countMyProcesses(User me) {
        int count = 0
        for (ReportProcess reportProcess : reportProcesses) {
            if (reportProcess.author.id.equals(me.id)) {
                count++
            }
        }
        return count
    }
}
