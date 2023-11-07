package pl.javastart.jpaoptimalization.country;

import java.util.stream.Collectors;

public class CountryWithLanguagesMapper {

    public static CountryWithLanguagesDto convertToCountryWithLanguageDto(Country country) {
        CountryWithLanguagesDto countryWithLanguagesDto = new CountryWithLanguagesDto();
        countryWithLanguagesDto.setCountryName(country.getName());
        countryWithLanguagesDto.setLanguages(
                country.getLanguages().stream()
                        .map(countryLanguage -> countryLanguage.toString() + ", ")
                        .collect(Collectors.joining()));
        return countryWithLanguagesDto;
    }
}
