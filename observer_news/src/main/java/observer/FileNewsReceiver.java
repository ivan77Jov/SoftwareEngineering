package observer;

import java.io.FileWriter;
import java.io.IOException;

public class FileNewsReceiver implements Observer{
    private final String filePath;

    public FileNewsReceiver(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void update(String news, String source, String timestamp) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write("[" + timestamp + "] (" + source + "): " + news + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    
}
