package pl.javastart.jpaoptimalization;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.javastart.jpaoptimalization.countryandlanguage.CountryRepository;

@SpringBootTest
class JpaoptimalizationApplicationTests {

    @Autowired
    private CountryRepository countryRepository;

    @Test
    void contextLoads() {

}
