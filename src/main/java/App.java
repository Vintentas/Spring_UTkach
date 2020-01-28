import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
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

    public void logEvent(Event msg) throws IOException {
      //  Event event = new Event(new Date(), DateFormat.getDateTimeInstance());
      //  event.setMsg(msg);
        eventLogger.logEvent(msg);
    }

    //use java
 /*   public static void main(String[] args) {
        App app = new App(new Client("1","John Smith"), new ConsoleEventLogger());
        app.logEvent("Some event fore user 1");
    }*/

   //use applicationContext in spring
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

        App app = (App) ctx.getBean("app");

        Event event = (Event) ctx.getBean("event");
        app.logEvent(event);

        event = (Event) ctx.getBean("event");
        app.logEvent(event);

        event = (Event) ctx.getBean("event");
        event.setMsg("new massage");
        app.logEvent(event);

        ctx.close();
    }
}
