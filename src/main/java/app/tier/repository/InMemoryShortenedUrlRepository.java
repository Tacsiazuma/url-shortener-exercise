package app.tier.repository;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class InMemoryShortenedUrlRepository implements ShortenedUrlRepository {

    private final Map<String, String> storage = new HashMap<>();
    @Override
    public void create(String url, String id) {
        if (storage.containsKey(id)) {
            throw new IllegalArgumentException("The id already exists!");
        }
        storage.put(id, url);
    }

    @Override
    public String get(String id) {
        return storage.get(id);
    }
}
