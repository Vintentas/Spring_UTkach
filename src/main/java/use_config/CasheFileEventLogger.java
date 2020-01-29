package use_config;

import java.util.List;


public class CasheFileEventLogger extends fileEventLogger {
    private int cacheSize;
    List<Event> cache;

    public CasheFileEventLogger(String filename, int cacheSize) {
        super(filename);
        this.cacheSize = cacheSize;
    }

    @Override
    public void logEvent(EventType type, Event msg){
        cache.add(msg);
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
