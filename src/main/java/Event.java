import java.text.DateFormat;
import java.util.Date;

public class Event {
    int id;
    String msg = "";
    Date date;
    DateFormat df;

    public Event (Date date, DateFormat df){
        this.date = date;
        this.df = df;
    }


    @Override
     public String toString(){
        setRandomId();
        return df.format(date) + ": " + id + " - " + msg;
    }

    void setRandomId (){
        id = (int) (Math.random()*100);
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
