package app.tier.repository;

public interface ShortenedUrlRepository {
    void create(String url, String shortenedUrl);
    String get(String url);
}
