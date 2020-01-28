import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

public class App {

    Client client;
    EventLogger eventLogger;

    public App(Client client, EventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(String msg) throws IOException {
        Event event = new Event(new Date(), DateFormat.getDateTimeInstance());
        event.setMsg(msg);
        eventLogger.logEvent(event);
    }

    //use java
 /*   public static void main(String[] args) {
        App app = new App(new Client("1","John Smith"), new ConsoleEventLogger());
        app.logEvent("Some event fore user 1");
    }*/

   //use applicationContext in spring
    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

        App app = (App) ctx.getBean("app1");
        app.logEvent("Some event fore user 1");
        app = (App) ctx.getBean("app2");
        app.logEvent("Some event fore user 2");
    }
}
