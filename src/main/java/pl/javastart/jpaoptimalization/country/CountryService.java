package pl.javastart.jpaoptimalization.country;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }
    public List<Country> findAllWithCities() {
        return countryRepository.findAllWithCities();
    }

    public List<CountryWithLanguagesDto> countryWithLanguagesDtoList() {
         return countryRepository.findAllWithLanguages().stream()
                .map(CountryWithLanguagesMapper::convertToCountryWithLanguageDto).collect(Collectors.toList());
    }
}
