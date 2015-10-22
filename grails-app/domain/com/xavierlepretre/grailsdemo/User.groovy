package com.xavierlepretre.grailsdemo

class User {

    String name;
    Locale locale;
    Collection reports;

    static hasMany = [reports: Report]

    static constraints = {
        name nullable: false, blank:false, unique:true
        locale nullable:false
    }

    static mapping = {
    }
}
