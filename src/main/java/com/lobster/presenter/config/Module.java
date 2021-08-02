package com.lobster.presenter.config;

import com.lobster.core.usecase.country.CountryRepository;
import com.lobster.core.usecase.country.CreateCountryUseCase;
import com.lobster.core.usecase.country.GetAllCountriesUseCase;
import com.lobster.core.usecase.country.GetCountryUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Module {

    @Bean
    public CreateCountryUseCase createCountryUseCase(CountryRepository repository) {
        return new CreateCountryUseCase(repository);
    }

    @Bean
    public GetAllCountriesUseCase getAllCountriesUseCase(CountryRepository repository) {
        return new GetAllCountriesUseCase(repository);
    }

    @Bean
    public GetCountryUseCase getCountryUseCase(CountryRepository repository) {
        return new GetCountryUseCase(repository);
    }
}
