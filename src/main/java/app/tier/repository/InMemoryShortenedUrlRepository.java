package app.tier.repository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryShortenedUrlRepository implements ShortenedUrlRepository {

    private final Map<String, String> storage = new HashMap<>();
    @Override
    public void create(String url, String id) {
        storage.put(id, url);
    }

    @Override
    public String get(String id) {
        return storage.get(id);
    }
}
