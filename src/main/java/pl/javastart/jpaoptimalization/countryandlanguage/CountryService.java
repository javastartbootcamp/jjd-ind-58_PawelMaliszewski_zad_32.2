package pl.javastart.jpaoptimalization.countryandlanguage;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

   public List<CountryWithHighestCityPopulationDto> countryWithHighestCityPopulationList() {
        return countryRepository.countryWithHighestCityPopulation().stream()
                .map(obj -> new CountryWithHighestCityPopulationDto(
                        obj[0].toString()
                        , obj[1].toString()
                        , Integer.parseInt(obj[2].toString()))).collect(Collectors.toList());
   }

    public List<CountryWithItsAllLanguagesDto> countryWithAllLanguagesList() {
        return countryRepository.getCountryWithAllLanguageInUSe()
                .stream().map(
                        obj -> new CountryWithItsAllLanguagesDto(obj[0].toString(), obj[1].toString())
                )
                .collect(Collectors.toList());
    }

    public List<LanguageWithAllCountriesThatAreUsingItDto> languageWithAllCountriesThatAreUsingItDTOList() {
        return countryRepository.getAllLanguagesAndCountriesThatAreUsingIt().stream()
                .map(obj -> new LanguageWithAllCountriesThatAreUsingItDto(obj[0].toString(), obj[1].toString()))
                .collect(Collectors.toList());
    }
}
