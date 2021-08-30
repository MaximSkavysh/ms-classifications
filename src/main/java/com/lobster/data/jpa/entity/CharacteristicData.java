package com.lobster.data.jpa.entity;

import com.lobster.core.domain.Characteristic;
import com.lobster.data.jpa.entity.localization.CommonLocalization;
import com.lobster.enums.CharacteristicType;
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
@Entity(name = "characteristics")
@Table(name = "characteristics")
public class CharacteristicData extends Audit {

    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identifier", length = 256, unique = true)
    private String identifier;

    @Column(name = "uid")
    private Long uid;

    @EqualsAndHashCode.Exclude
    @Type(type = "jsonb")
    @Column(name = "name", columnDefinition = "jsonb")
    private Set<CommonLocalization> name = new HashSet<>();

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private CharacteristicType type;

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "characteristic_attributes",
            joinColumns = @JoinColumn(name = "characteristic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id", referencedColumnName = "id"))
    private Set<AttributeData> attributeData = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "characteristic_countries",
            joinColumns = @JoinColumn(name = "characteristic_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "country_id", referencedColumnName = "id"))
    private Set<CountryData> countryData = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryData categoryData;

    public CharacteristicData(Characteristic characteristic) {
        this.id = characteristic.getId();
        this.identifier = characteristic.getIdentifier();
        this.name = CommonLocalization.localizationMapToSet(characteristic.getName());
        this.type = characteristic.getCharacteristicType();
    }


    public static CharacteristicData from(Characteristic characteristic) {
        return new CharacteristicData(characteristic);
    }

    public Characteristic fromThis() {
        return new Characteristic(id,
                identifier,
                CommonLocalization.localizationsToMap(name, CommonLocalization::getValue),
                type);
    }
}
