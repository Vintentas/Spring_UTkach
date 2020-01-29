package use_config;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.Map;

public class App {

    Client client;
    EventLogger eventLogger;
    Map<EventType, EventLogger> loggers;

    public App(Client client, EventLogger eventLogger, Map<EventType, EventLogger> loggers){
        this.client = client;
        this.eventLogger = eventLogger;
        this.loggers = loggers;
    }

    public void logEvent(EventType type, Event msg) throws IOException {
      //  use_config.Event event = new use_config.Event(new Date(), DateFormat.getDateTimeInstance());
      //  event.setMsg(msg);
        eventLogger.logEvent(type, msg);
    }

    //use java
 /*   public static void main(String[] args) {
        use_config.App app = new use_config.App(new use_config.Client("1","John Smith"), new use_config.ConsoleEventLogger());
        app.logEvent("Some event fore user 1");
    }*/

   //use applicationContext in spring
    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");

        App app = (App) ctx.getBean("app");

        Event event = (Event) ctx.getBean("event");
        app.logEvent(EventType.INFO, event);

        event = (Event) ctx.getBean("event");
        app.logEvent(EventType.INFO, event);

        event = (Event) ctx.getBean("event");
        event.setMsg("new massage");
        app.logEvent(EventType.INFO, event);

        ctx.close();
    }

}
