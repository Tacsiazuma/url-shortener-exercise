package app.tier.api;


import app.tier.facade.UrlShortenerFacade;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class RedirectController {

    private final UrlShortenerFacade facade;

    public RedirectController(UrlShortenerFacade facade) {
        this.facade = facade;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{shortened}")
    public String get(String shortened) {
        return "redirect:" + facade.get(shortened);
    }
}
