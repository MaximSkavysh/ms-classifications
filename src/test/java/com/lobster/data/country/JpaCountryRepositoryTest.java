package com.lobster.data.country;

import com.lobster.TestEntityGenerator;
import com.lobster.data.jpa.entity.CountryData;
import com.lobster.data.jpa.repository.country.CountryJpaRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class JpaCountryRepositoryTest {

    @Autowired
    public CountryJpaRepository repository;

    @BeforeEach
    void initUseCase() {
        List<CountryData> countryData = TestEntityGenerator.randomCountries()
                .stream()
                .map(CountryData::from)
                .collect(Collectors.toList());

        repository.saveAll(countryData);
    }

    @AfterEach
    void destroyAll() {
        repository.deleteAll();
    }

    @Test
    void findAll_success() {
        List<CountryData> allCountries = repository.findAll();
        assertThat(allCountries.size()).isPositive();
    }
}
