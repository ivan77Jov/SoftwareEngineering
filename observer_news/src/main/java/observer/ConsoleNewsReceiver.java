package observer;

public class ConsoleNewsReceiver implements Observer {
    @Override
    public void update(String news, String source, String timestamp) {
        System.out.println("[" + timestamp + "] (" + source + "): " + news);
    }
}
