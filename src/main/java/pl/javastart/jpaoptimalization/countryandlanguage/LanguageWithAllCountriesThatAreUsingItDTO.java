package pl.javastart.jpaoptimalization.countryandlanguage;

public class LanguageWithAllCountriesThatAreUsingItDTO {

    private String language;
    private String countries;

    public LanguageWithAllCountriesThatAreUsingItDTO(String language, String countries) {
        this.language = language;
        this.countries = countries;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountries() {
        return countries;
    }

    public void setCountries(String countries) {
        this.countries = countries;
    }
}
