package com.xavierlepretre.grailsdemo

class User {

    String name;
    Locale locale;

    static hasMany = [reports: Report]

    static constraints = {
        name nullable: false, blank:false, unique:true
        locale nullable:false
    }
}
