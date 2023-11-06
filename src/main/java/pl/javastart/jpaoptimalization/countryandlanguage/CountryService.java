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

   public List<CountryWithHighestCityPopulationDTO> countryWithHighestCityPopulationList() {
        return countryRepository.countryWithHighestCityPopulation().stream()
                .map(obj -> new CountryWithHighestCityPopulationDTO(
                        obj[0].toString()
                        , obj[1].toString()
                        , Integer.parseInt(obj[2].toString()))).collect(Collectors.toList());
   }

    public List<CountryWithItsAllLanguagesDTO> countryWithAllLanguagesList() {
        return countryRepository.getCountryWithAllLanguageInUSe()
                .stream().map(
                        obj -> new CountryWithItsAllLanguagesDTO(obj[0].toString(), obj[1].toString())
                )
                .collect(Collectors.toList());
    }

    public List<LanguageWithAllCountriesThatAreUsingItDTO> languageWithAllCountriesThatAreUsingItDTOList() {
        return countryRepository.getAllLanguagesAndCountriesThatAreUsingIt().stream()
                .map(obj -> new LanguageWithAllCountriesThatAreUsingItDTO(obj[0].toString(), obj[1].toString()))
                .collect(Collectors.toList());
    }
}
