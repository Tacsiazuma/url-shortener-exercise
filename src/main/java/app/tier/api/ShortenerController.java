package app.tier.api;

import app.tier.api.response.GeneratedUrl;
import app.tier.facade.UrlShortenerFacade;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortenerController {

    private final UrlShortenerFacade facade;

    public ShortenerController(UrlShortenerFacade facade) {
        this.facade = facade;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/url")
    public GeneratedUrl generate(@RequestParam("url") String url) {
        return new GeneratedUrl(facade.shorten(url));
    }

}
