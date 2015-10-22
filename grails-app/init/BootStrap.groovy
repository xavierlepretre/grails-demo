import com.xavierlepretre.grailsdemo.Report
import com.xavierlepretre.grailsdemo.User
import grails.util.Environment

class BootStrap {

    def init = { servletContext ->
        if(Environment.current == Environment.DEVELOPMENT) {
            def user1 = new User(name: "John", locale: new Locale("en", "GB"))
            user1.save(flush: true)

            def report1 = new Report(author: user1)
            report1.save(flush: true)

            def user2 = new User(name: "Jean", locale: new Locale("fr", "FR"))
            user2.save(flush: true)
        }
    }

    def destroy = {
    }
}
