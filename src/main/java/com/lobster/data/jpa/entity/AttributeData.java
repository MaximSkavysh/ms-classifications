package com.lobster.data.jpa.entity;

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
@Entity(name = "attributes")
@Table(name = "attributes")
public class AttributeData {
    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "identifier", nullable = false, unique = true, length = 64)
    private String identifier;

    @Type(type = "jsonb")
    @Column(name = "name", columnDefinition = "jsonb")
    private Set<CommonLocalization> name;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "attributeData")
    Set<CharacteristicData> characteristicData = new HashSet<>();
}
