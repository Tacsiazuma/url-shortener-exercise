package app.tier.config;

import app.tier.facade.UrlShortenerFacade;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlShortenerConfiguration {
    public UrlShortenerFacade testFacade() {
        return urlShortenerFacade();
    }

    @Bean
    public UrlShortenerFacade urlShortenerFacade() {
        return new UrlShortenerFacade();
    }
}
