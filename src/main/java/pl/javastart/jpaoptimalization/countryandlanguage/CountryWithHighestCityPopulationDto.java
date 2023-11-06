package pl.javastart.jpaoptimalization.countryandlanguage;

public class CountryWithHighestCityPopulationDto {
    private String name;
    private String cityName;
    private int population;

    public CountryWithHighestCityPopulationDto(String name, String cityName, int population) {
        this.name = name;
        this.cityName = cityName;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
