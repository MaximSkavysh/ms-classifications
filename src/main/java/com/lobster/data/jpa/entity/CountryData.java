package com.lobster.data.jpa.entity;

import com.lobster.core.domain.Country;
import com.lobster.data.jpa.entity.localization.CommonLocalization;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "countries")
public class CountryData {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identifier", nullable = false, unique = true, length = 64)
    private String identifier;

    @Type(type = "jsonb")
    @Column(name = "name", columnDefinition = "jsonb")
    private Set<CommonLocalization> name = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "countries")
    Set<Characteristic> characteristics = new HashSet<>();

    public CountryData(Long id, String identifier, Set<CommonLocalization> name) {
        this.id = id;
        this.identifier = identifier;
        this.name = name;
    }

    public static CountryData from(Country country) {
        return new CountryData(
                country.getId(),
                country.getIdentifier(),
                CommonLocalization.localizationMapToSet(country.getName())
        );
    }

    public Country fromThis() {
        return new Country(
                id,
                identifier,
                CommonLocalization.localizationsToMap(name, CommonLocalization::getValue)
        );
    }

}
