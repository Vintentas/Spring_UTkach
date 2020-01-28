import java.text.DateFormat;
import java.util.Date;

public class Event {
    int id;
    String msg = "no massage";
    Date date;
    DateFormat df;

    public Event (Date date, DateFormat df){
        this.date = date;
        this.df = df;
        id = (int) (Math.random()*100);
    }


    @Override
     public String toString(){
        return df.format(date) + ": " + id + " - " + msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
