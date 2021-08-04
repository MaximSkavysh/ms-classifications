package com.lobster.presenter.rest.controller.country;

import com.lobster.dto.ResponseDto;
import com.lobster.presenter.rest.entities.CountryRequest;
import com.lobster.presenter.rest.entities.CountryResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/classification/country")
@Validated
public interface CountryResource {

    @GetMapping("/all")
    CompletableFuture<ResponseDto<List<CountryResponse>>> getAllCountries();

    @PostMapping
    CompletableFuture<ResponseDto<CountryResponse>> createCountry(@RequestBody CountryRequest countryRequest);

    @GetMapping("/{id}")
    CompletableFuture<ResponseDto<CountryResponse>> getCountry(@PathVariable Long id);

    @PutMapping
    CompletableFuture<ResponseDto<CountryResponse>> updateCountry(@RequestBody @Valid CountryRequest countryRequest);
}
