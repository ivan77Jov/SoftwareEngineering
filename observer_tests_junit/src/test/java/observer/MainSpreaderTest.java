package observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainSpreaderTest {

    private MainSpreader spreader;

    @BeforeEach
    void setUp() {
        spreader = new MainSpreader();
    }

    @Test
    void testRegisterTrustedSourceSuccess() {
        assertTrue(spreader.registerTrustedSource("source1", "password123"));
    }

    @Test
    void testRegisterTrustedSourceDuplicate() {
        spreader.registerTrustedSource("source1", "password123");
        assertFalse(spreader.registerTrustedSource("source1", "password123"));
    }

    @Test
    void testSpreadNewsSuccess() throws Exception {
        spreader.registerTrustedSource("source1", "password123");
        spreader.addObserver(new ConsoleNewsReceiver());
        String news = spreader.spreadNews("Breaking news", "source1", "password123");
        assertEquals("Breaking news", news);
    }

    @Test
    void testSpreadNewsUntrustedSource() {
        assertThrows(UntrustedSourceException.class, () -> {
            spreader.spreadNews("Fake news", "unknownSource", "password");
        });
    }

    @Test
    void testSpreadNewsWrongPassword() {
        spreader.registerTrustedSource("source1", "password123");
        assertThrows(AuthenticationException.class, () -> {
            spreader.spreadNews("Fake news", "source1", "wrongPassword");
        });
    }
    // blocking the word "forbidden"
    @Test
    void testSpreadNewsBlockedContent() {
        spreader.registerTrustedSource("source1", "password123");
        spreader.blockWord("forbidden", false);
        assertThrows(BlockedContentException.class, () -> {
            spreader.spreadNews("This contains forbidden content", "source1", "password123");
        });
    }
    //test # 
    @Test
    void testBlockAndRedactWord() throws Exception {
        spreader.registerTrustedSource("source1", "password123");
        spreader.blockWord("redact", true);
        String news = spreader.spreadNews("This will redact content", "source1", "password123");
        assertEquals("This will # content", news);
    }

    @Test
    void testUnblockWord() throws Exception {
        spreader.registerTrustedSource("source1", "password123");
        spreader.blockWord("unblock", false);
        spreader.unblockWord("unblock");
        String news = spreader.spreadNews("This will unblock content", "source1", "password123");
        assertEquals("This will unblock content", news);
    }
    //check if the observer is updated
    @Test
    void testObserverNotification() throws Exception {
        MockObserver observer = new MockObserver();
        spreader.addObserver(observer);
        spreader.registerTrustedSource("source1", "password123");
        spreader.spreadNews("News for observers", "source1", "password123");
        assertTrue(observer.isUpdated());
    }
    //since the observer is removed, it cannot get updated
    @Test
    void testRemoveObserver() throws Exception {
        MockObserver observer = new MockObserver();
        spreader.addObserver(observer);
        spreader.removeObserver(observer);
        spreader.registerTrustedSource("source1", "password123");
        spreader.spreadNews("News for observers", "source1", "password123");
        assertFalse(observer.isUpdated());
    }
}

// Mock class for testing Observer behavior
class MockObserver implements Observer {
    private boolean updated = false;

    @Override
    public void update(String news, String source, String timestamp) {
        this.updated = true;
    }

    public boolean isUpdated() {
        return updated;
    }
}

