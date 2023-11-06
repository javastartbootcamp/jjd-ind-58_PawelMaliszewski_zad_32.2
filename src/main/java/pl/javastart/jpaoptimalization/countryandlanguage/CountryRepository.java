package pl.javastart.jpaoptimalization.countryandlanguage;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Query(value = "SELECT COUNTRY.NAME, CITY.NAME AS CITY_NAME, CITY.POPULATION FROM COUNTRY " +
                   "JOIN (SELECT COUNTRYCODE, NAME, POPULATION, ROW_NUMBER() " +
                   "OVER(PARTITION BY COUNTRYCODE ORDER BY POPULATION DESC) AS RN FROM CITY) CITY " +
                   "ON CITY.COUNTRYCODE=COUNTRY.CODE AND RN=1 ORDER BY COUNTRY.NAME", nativeQuery = true)
    List<Object[]> countryWithHighestCityPopulation();

    @Query(value = "select country.Name, group_concat(concat(countrylanguage.Language, ' ', countrylanguage.Percentage, '%') " +
                   "order by countrylanguage.Percentage separator ', ') as lang from country, countrylanguage " +
                   "Where country.Code = countrylanguage.CountryCode group by countrylanguage.CountryCode " +
                   "order by country.Name;", nativeQuery = true)
    List<Object[]> getCountryWithAllLanguageInUSe();

    @Query(value = "SELECT Language, group_concat(country.Name order by country.Name separator ', ') as Countries " +
                   "from countrylanguage, country where countrylanguage.CountryCode=country.Code " +
                   "group by Language order by Language;", nativeQuery = true)
    List<Object[]> getAllLanguagesAndCountriesThatAreUsingIt();
}
