package pl.javastart.jpaoptimalization.country;

public class CountryWithLanguagesDto {

    private String countryName;
    private String languages;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }
}
