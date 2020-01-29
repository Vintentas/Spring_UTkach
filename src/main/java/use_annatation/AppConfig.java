package use_annatation;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import use_config.App;
import use_config.Client;
import use_config.Event;
import use_config.EventType;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    public Client client(){
        return new Client();
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

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
