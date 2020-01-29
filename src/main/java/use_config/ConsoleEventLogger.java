package use_config;

public class ConsoleEventLogger implements EventLogger {

    @Override
    public void logEvent (EventType type, Event msg){
        System.out.println(msg.toString());
    }
}
