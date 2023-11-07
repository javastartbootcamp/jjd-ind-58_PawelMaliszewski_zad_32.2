package pl.javastart.jpaoptimalization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.jpaoptimalization.country.CountryService;
import pl.javastart.jpaoptimalization.countrylanguage.CountryLanguageService;

@Controller
public class MainController {

    private final CountryService countryService;
    private final CountryLanguageService countryLanguageService;

    public MainController(CountryService countryService,
                          CountryLanguageService countryLanguageService) {
        this.countryService = countryService;
        this.countryLanguageService = countryLanguageService;
    }

    @GetMapping("/najwieksze-miasta")
    public String countryWithBiggestCity(Model model) {
        model.addAttribute("countries", countryService.findAllWithCities());
        return "countryWithBiggestCity";
    }

    @GetMapping("/kraje-i-jezyki")
    public String countryWithLanguages(Model model) {
        model.addAttribute("countries", countryService.countryWithLanguagesDtoList());
        return "countryWithLanguages";
    }

    @GetMapping("/jezyki-i-kraje")
    public String languagesWithCountries(Model model) {
        model.addAttribute("langAndCountries", countryLanguageService.languageAsKeyAndCountriesThatAreUsingItAsValue());
        return "languagesWithCountries";
    }
}
