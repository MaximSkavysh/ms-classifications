package com.lobster.data.jpa.entity.localization;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;


@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class Localization {

    @Size(max = 10)
    private String lang;

    public Localization(String lang) {
        this.lang = lang;
    }
}

