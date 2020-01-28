import java.io.File;
import java.util.List;


public class CasheFileEventLogger extends fileEventLogger {
    private int cacheSize;
    List<Event> cache;

    public CasheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    public void logEvent(Event event){
        cache.add(event);
        if (cache.size() == cacheSize){
            writeEventsFromCache();
            cache.clear();
        }
    }

    public void writeEventsFromCache(){
        //я пишу в кеш
    }

    public void  init(){
        super.init();
    }

    public void destroy(){
        if (!cache.isEmpty())
            writeEventsFromCache();
    }
}
