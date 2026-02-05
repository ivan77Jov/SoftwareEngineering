package observer;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

/**
*  TODO: Complete the implementation. Do not change class name and existing method signatures. You may add base class and other interfaces. Make sure that the class works with the default constructor.
* 
*/
public class MainSpreader implements NewsSpreader {

	private final Map<String, String> trustedSources = new HashMap<>(); 
	private final List<Observer> observers = new ArrayList<>();
	private final Map<String, Boolean> blockedWords = new HashMap<>(); 


	// Default constructor must be present, you may add implementation if needed
	public MainSpreader(){

	}
	
	@Override
	public boolean registerTrustedSource(String source, String pwd){
		if (source == null || pwd == null || pwd.isEmpty() || trustedSources.containsKey(source)||source.isEmpty() ) {
            return false;
        }
        trustedSources.put(source, hashPassword(pwd));
        return true;
	}
	
	@Override
	public String spreadNews(String news, String source, String pwd) throws NewsSpreaderException {
		if (news == null || source == null || pwd == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        if (!trustedSources.containsKey(source)) {
            throw new UntrustedSourceException(source);
        }
        if (!trustedSources.get(source).equals(hashPassword(pwd))) {
            throw new AuthenticationException(source);
        }

        for (Map.Entry<String, Boolean> entry : blockedWords.entrySet()) {
            String word = entry.getKey();
            boolean redact = entry.getValue();

            if (news.matches("(?i).*\\b" + word + "\\b.*")) {
                if (redact) {
                    news = news.replaceAll("(?i)\\b" + word + "\\b", "#");
                } else {
                    throw new BlockedContentException(word);
                }
            }
        }

        String timestamp = LocalDateTime.now().toString();
        notifyObservers(news, source, timestamp);
        return news;		
		
	}

	@Override
	public boolean blockWord(String word2block, boolean redact) {
		if (word2block == null || word2block.trim().isEmpty() || !word2block.trim().matches("^\\w+$")) return false;
        blockedWords.put(word2block.trim().toLowerCase(), redact);
        return true;
		
	}

	@Override
	public boolean unblockWord(String word2free) {
		if (word2free == null || word2free.isEmpty()) return false;
        return blockedWords.remove(word2free.toLowerCase()) != null;
	}

	private String hashPassword(String pwd) {
		return Integer.toHexString(pwd.hashCode());
	}

	public void addObserver(Observer observer) {
        observers.add(observer);
    }

	public void removeObserver(Observer observer) {
		observers.remove(observer);
	}
	

	private void notifyObservers(String news, String source, String timestamp) {
        for (Observer observer : observers) {
            observer.update(news, source, timestamp);
        }
    }

}
