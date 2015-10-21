package com.xavierlepretre.grailsdemo

class Report {

    String name;

    static belongsTo = [author: User]

    static constraints = {
        name nullable: false, blank: false
    }
}
