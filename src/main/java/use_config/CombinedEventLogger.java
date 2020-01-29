package use_config;

import java.io.IOException;
import java.util.List;

public class CombinedEventLogger implements  EventLogger{

    List<EventLogger> loggers;

    public CombinedEventLogger (List<EventLogger> loggers){
        this.loggers = loggers;
    }

    @Override
    public void logEvent(EventType type, Event msg) throws IOException {
        //я пишу в файл
    }
}
