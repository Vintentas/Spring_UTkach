package use_config;

import java.io.IOException;

public interface EventLogger {
    void logEvent(EventType type, Event msg) throws IOException;
}
