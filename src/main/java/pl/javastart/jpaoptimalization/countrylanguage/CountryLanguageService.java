package pl.javastart.jpaoptimalization.countrylanguage;

import org.springframework.stereotype.Service;
import pl.javastart.jpaoptimalization.country.Country;
import pl.javastart.jpaoptimalization.country.CountryRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;
    private final CountryRepository countryRepository;

    public CountryLanguageService(CountryLanguageRepository countryLanguageRepository, CountryRepository countryRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
        this.countryRepository = countryRepository;
    }

    public List<CountryLanguage> findAll() {
        return countryLanguageRepository.findAll();
    }

    public Map<String, String> languageAsKeyAndCountriesThatAreUsingItAsValue() {
        Map<String, String> countryCodeCountryName = countryRepository.findAll().stream()
                .collect(Collectors.toMap(Country::getCode, Country::getName));
        Map<String, String> collect = countryLanguageRepository.findAll().stream()
                .collect(
                        Collectors.groupingBy(
                                CountryLanguage::getLanguage,
                                Collectors
                                        .mapping(
                                                countryLanguage -> countryCodeCountryName.get(countryLanguage.getCountryCode()) + ", ",
                                                Collectors.joining())));
        return new TreeMap<>(collect);
    }
}