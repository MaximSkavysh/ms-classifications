package com.lobster.data.jpa.entity;

import com.lobster.core.domain.Category;
import com.lobster.data.jpa.entity.localization.CommonLocalization;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "categories")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
@Table(name = "categories", indexes = {@Index(name = "IDENTIFIER", columnList = "identifier")})
public class CategoryData extends Audit {

    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identifier", nullable = false, unique = true, length = 64)
    private String identifier;

    @EqualsAndHashCode.Exclude

    @Type(type = "jsonb")
    @Column(name = "name", columnDefinition = "jsonb")
    private Set<CommonLocalization> name;

    @Column(name = "used_for_template")
    private boolean usedForTemplate;


    @OneToMany(mappedBy = "categoryData", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    Set<CharacteristicData> characteristicData = new HashSet<>();

    public CategoryData(Category category) {
        this.id = category.getId();
        this.identifier = category.getIdentifier();
        this.name = CommonLocalization.localizationMapToSet(category.getName());
        this.usedForTemplate = category.isUsedForTemplate();
        this.characteristicData = new HashSet<>();
    }

    public static CategoryData from(Category category) {
        return new CategoryData(category);
    }


    public Category fromThis() {
        return new Category(id,
                identifier,
                CommonLocalization.localizationsToMap(name, CommonLocalization::getValue),
                usedForTemplate,
                new HashSet<>());
    }
}
