package app.tier.config;

import app.tier.facade.UrlShortenerFacade;
import app.tier.repository.InMemoryShortenedUrlRepository;
import app.tier.repository.ShortenedUrlRepository;
import app.tier.service.RandomIdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UrlShortenerConfiguration {
    public UrlShortenerFacade testFacade() {
        return urlShortenerFacade(new InMemoryShortenedUrlRepository(),
                new RandomIdGenerator());
    }

    @Bean
    public UrlShortenerFacade urlShortenerFacade(ShortenedUrlRepository repository,
                                                 RandomIdGenerator randomIdGenerator) {
        return new UrlShortenerFacade(randomIdGenerator, repository);
    }
}
