import java.util.List;


public class CasheFileEventLogger extends fileEventLogger {
    private int cacheSize;
    List<Event> cache;

    public CasheFileEventLogger(String filename) {
        super(filename);
    }

    public void logEvent(Event event){
        cache.add(event);
        
        if (cache.size() ==cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
                
    }

    public void writeEventsFromCache(){

    }
}
