package use_config;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class fileEventLogger  implements EventLogger{

    private String filename;
    File file;

    public fileEventLogger (String filename){
        this.filename = filename;
    }

    public void  init(){
        this.file = new File(filename);
        file.canWrite();
    }

    @Override
    public void logEvent(EventType type, Event msg) throws IOException {
        FileUtils.writeStringToFile(file , msg.toString(), true);
    }

}
