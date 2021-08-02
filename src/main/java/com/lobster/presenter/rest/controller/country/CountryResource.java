package com.lobster.presenter.rest.controller.country;

import com.lobster.dto.ResponseDto;
import com.lobster.presenter.rest.entities.CountryRequest;
import com.lobster.presenter.rest.entities.CountryResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/classification/country")
public interface CountryResource {

    @GetMapping
    CompletableFuture<ResponseDto<List<CountryResponse>>> getAllCountries();

    @PostMapping
    CompletableFuture<ResponseDto<CountryResponse>> createCountry(@RequestBody CountryRequest countryRequest);
}
