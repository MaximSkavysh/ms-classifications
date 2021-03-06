package com.lobster;

import com.github.javafaker.Faker;
import com.lobster.core.domain.Country;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class TestEntityGenerator {
    private static final Faker faker = new Faker();
    private static final List<String> languages = List.of("ru", "en", "de", "it");

    private static <T> List<T> randomItemsOf(Supplier<T> generator) {
        return IntStream.rangeClosed(0, randomNumberBetweenFiveAndTen())
                .mapToObj(number -> (T) generator.get())
                .collect(Collectors.toList());
    }

    private static int randomNumberBetweenFiveAndTen() {
        return faker.number().numberBetween(5, 10);
    }

    public static Integer randomQuantity() {
        return randomNumberBetweenFiveAndTen();
    }

    public static Long randomId() {
        return faker.number().randomNumber();
    }

    public static Country randomCountry() {
        return new Country(
                randomId(),
                faker.name().name(),
                languages.stream()
                        .collect(Collectors.toMap(Function.identity(), s -> getName()))
        );
    }

    private static String getName() {
        return faker.funnyName().name();
    }

    public static List<Country> randomCountries() {
        return randomItemsOf(TestEntityGenerator::randomCountry);
    }

}
