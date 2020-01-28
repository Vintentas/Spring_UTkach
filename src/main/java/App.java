public class App {

    Client client;
    EventLogger eventLogger;

    public static void main(String[] args) {

        App app = new App(new Client("1","John Smith"), new ConsoleEventLogger());
        app.logEvent("Some event fore user 1");
    }

    public App(Client client, EventLogger eventLogger){
        this.client = client;
        this.eventLogger = eventLogger;
    }

    public void logEvent(String msg){
        String message = msg.replace(client.getId(), client.getFullName());
        eventLogger.logEvent(message);
    }
}
