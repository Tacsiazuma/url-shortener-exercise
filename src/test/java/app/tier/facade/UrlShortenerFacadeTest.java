package app.tier.facade;

import app.tier.config.UrlShortenerConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UrlShortenerFacadeTest {

    private final UrlShortenerFacade underTest = new UrlShortenerConfiguration().testFacade();

    @Test
    public void itShouldReturnIdWhenShortenCalledWithValidUrl() {
        // GIVEN
        String url = "https://www.example.com";
        // WHEN
        String actual = underTest.shorten(url);
        // THEN
        assertEquals("repeat", actual);
    }

    @Test
    public void itShouldRetryWhenSameIdIsGenerated() {
        // GIVEN
        String url = "https://www.example.com";
        String previous = underTest.shorten(url);
        // WHEN
        String actual = underTest.shorten(url);
        // THEN
        assertNotEquals(previous, actual);
    }
    @Test
    public void itShouldReturnTargetUrlIfIdExists() {
        // GIVEN
        String url = "https://www.example.com";
        String id = underTest.shorten(url);
        // WHEN
        String actual = underTest.get(id);
        // THEN
        assertEquals(url, actual);
    }

    @Test
    public void itShouldThrowInvalidArgumentWhenEmptyUrlGiven() {
        // GIVEN
        String url = "";
        // WHEN
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            underTest.shorten(url);
        });
        // THEN
        assertEquals("Url to be shortened should not be empty", thrown.getMessage());
    }

    @Test
    public void itShouldThrowInvalidArgumentWhenInvalidUrlGiven() {
        // GIVEN
        String url = "some.invalid.url";
        // WHEN
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            underTest.shorten(url);
        });
        // THEN
        assertEquals("Url should be valid", thrown.getMessage());
    }
}
