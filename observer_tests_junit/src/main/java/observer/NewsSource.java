package observer;

public class NewsSource {
    private final NewsSpreader spreader;
    private final String sourceName;
    private final String password;

    public NewsSource(NewsSpreader spreader, String sourceName, String password) {
        this.spreader = spreader;
        this.sourceName = sourceName;
        this.password = password;
        spreader.registerTrustedSource(sourceName, password);
    }

    public void sendNews(String news) {
        try {
            spreader.spreadNews(news, sourceName, password);
        } catch (NewsSpreaderException e) {
            System.err.println("Failed to spread news: " + e.getMessage());
        }
    }
    
}
