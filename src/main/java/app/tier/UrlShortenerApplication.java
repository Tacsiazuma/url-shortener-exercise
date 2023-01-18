package app.tier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "app.tier.*")
public class UrlShortenerApplication {
    public static void main(String[] args) {
        SpringApplication.run(UrlShortenerApplication.class, args);
    }
}