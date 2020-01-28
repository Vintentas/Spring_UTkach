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


    public void logEvent(Event msg) throws IOException {
        FileUtils.writeStringToFile(file , msg.toString(), true);
    }

}
