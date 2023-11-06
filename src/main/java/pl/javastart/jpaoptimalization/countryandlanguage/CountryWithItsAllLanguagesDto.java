package pl.javastart.jpaoptimalization.countryandlanguage;

public class CountryWithItsAllLanguagesDto {
    private String country;
    private String languages;

    public CountryWithItsAllLanguagesDto(String country, String languages) {
        this.country = country;
        this.languages = languages;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
