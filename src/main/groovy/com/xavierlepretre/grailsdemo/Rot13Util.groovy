package com.xavierlepretre.grailsdemo

/**
 * Taken from http://www.bytemycode.com/snippets/snippet/754/
 */
class Rot13Util {

    def redundanceFreeRot13 = {
        it.inject(''){ result, c ->
            result + (char)((c as char) + rotCount(c))
        }
    }

    def rotCount(c) {
        if(c in upperAndLowerCase('a'..'m')) return  13
        if(c in upperAndLowerCase('n'..'z')) return -13
        0
    }

    def upperAndLowerCase(characters) {
        characters*.toUpperCase() + characters*.toLowerCase()
    }

}
