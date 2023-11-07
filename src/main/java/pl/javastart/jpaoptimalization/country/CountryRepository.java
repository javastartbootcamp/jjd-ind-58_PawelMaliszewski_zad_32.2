package pl.javastart.jpaoptimalization.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Query("select distinct c from Country c left join fetch c.cities order by c.name")
    List<Country> findAllWithCities();

    @Query("select distinct c from Country c left join fetch c.languages order by c.name")
    List<Country> findAllWithLanguages();

}