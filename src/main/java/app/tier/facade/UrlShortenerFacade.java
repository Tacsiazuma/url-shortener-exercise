package app.tier.facade;


import app.tier.repository.ShortenedUrlRepository;
import app.tier.service.RandomIdGenerator;

public class UrlShortenerFacade {
    private final RandomIdGenerator randomIdGenerator;
    private final ShortenedUrlRepository repository;

    public UrlShortenerFacade(RandomIdGenerator randomIdGenerator, ShortenedUrlRepository repository) {
        this.randomIdGenerator = randomIdGenerator;
        this.repository = repository;
    }

    public String shorten(String url) {
        if (url.isEmpty()) {
            throw new IllegalArgumentException("Url to be shortened should not be empty");
        }
        // IDs should be generated beforehand in this way we can just pick up one which is guaranteed to be unique
        String id = randomIdGenerator.getBase58(6);
        repository.create(url, id);
        return id;
    }

    public String get(String shortened) {
        return repository.get(shortened);
    }
}
