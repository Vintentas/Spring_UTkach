import java.io.IOException;

public interface EventLogger {
    void logEvent(Event msg) throws IOException;
}
