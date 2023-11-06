package pl.javastart.jpaoptimalization;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.javastart.jpaoptimalization.countryandlanguage.CountryService;

@Controller
public class MainController {

    private final CountryService countryService;

    public MainController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/najwieksze-miasta")
    public String countryWithBiggestCity(Model model) {
        model.addAttribute("countries", countryService.countryWithHighestCityPopulationList());
        return "countryWithBiggestCity";
    }

    @GetMapping("/kraje-i-jezyki")
    public String countryWithLanguages(Model model) {
        model.addAttribute("countryWithAllLang", countryService.countryWithAllLanguagesList());
        return "countryWithLanguages";
    }

    @GetMapping("/jezyki-i-kraje")
    public String languagesWithCountries(Model model) {
        model.addAttribute("langWithCtry", countryService.languageWithAllCountriesThatAreUsingItDTOList());
        return "languagesWithCountries";
    }
}
