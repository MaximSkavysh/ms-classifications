package com.lobster.presenter.config;

import com.lobster.core.usecase.category.CategoryRepository;
import com.lobster.core.usecase.category.CreateCategoryUseCase;
import com.lobster.core.usecase.characteristic.CharacteristicRepository;
import com.lobster.core.usecase.characteristic.CreateCharacteristicUseCase;
import com.lobster.core.usecase.country.*;
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

    @Bean
    public CreateCategoryUseCase createCategoryUseCase(CategoryRepository repository) {
        return new CreateCategoryUseCase(repository);
    }

    @Bean
    public UpdateCountryUseCase updateCountryUseCase(CountryRepository repository) {
        return new UpdateCountryUseCase(repository);
    }

    @Bean
    public CreateCharacteristicUseCase createCharacteristicUseCase(CharacteristicRepository repository) {
        return new CreateCharacteristicUseCase(repository);
    }
}
