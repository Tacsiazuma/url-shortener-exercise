package app.tier.repository;

public interface ShortenedUrlRepository {
    /**
     * Creates a new shortened URL mapping
     * @param url the url to be shortened
     * @param id the ID of the shortened URL
     * @throws IllegalArgumentException if the given ID already exists
     */
    void create(String url, String id);

    /**
     * Gets an url for the given ID
     * @param id the ID of the shortened URL
     * @return the shortened URL
     */
    String get(String id);
}
