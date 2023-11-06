package pl.javastart.jpaoptimalization.countryandlanguage;

import javax.persistence.*;

@Entity
class Country {
    @Id
    @Column(name = "Code")
    private String code;

    @Column(name = "Name")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
