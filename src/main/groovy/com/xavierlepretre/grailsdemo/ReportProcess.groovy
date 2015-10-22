package com.xavierlepretre.grailsdemo

class ReportProcess {

    static MILLISEC_DURATION = 3000;

    final Date startedAt
    final User author

    ReportProcess(User author) {
        this(new Date(), author)
    }

    ReportProcess(Date startedAt, User author) {
        this.startedAt = startedAt
        this.author = author
        if (startedAt == null) {
            throw new IllegalArgumentException("StartedAt cannot be null")
        }
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be null")
        }
    }

    boolean isDone() {
        long milliSecNow = new Date().toTimestamp().getTime()
        long milliSecStart = startedAt.toTimestamp().getTime()

        return milliSecNow - milliSecStart >= MILLISEC_DURATION
    }
}
