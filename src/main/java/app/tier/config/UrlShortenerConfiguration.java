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
        return urlShortenerFacade(new RandomIdGenerator() {
            private int index = 0;
            private String[] strings = new String[] {
                    "repeat", "repeat", "random"
            };
            @Override
            public String getBase58(int length) {
                return strings[index++];
            }
        }, new InMemoryShortenedUrlRepository());
    }

    @Bean
    public UrlShortenerFacade urlShortenerFacade(RandomIdGenerator randomIdGenerator, ShortenedUrlRepository repository) {
        return new UrlShortenerFacade(randomIdGenerator, repository);
    }
}
