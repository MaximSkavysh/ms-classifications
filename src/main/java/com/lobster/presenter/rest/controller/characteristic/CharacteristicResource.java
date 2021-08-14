package com.lobster.presenter.rest.controller.characteristic;


import com.lobster.dto.ResponseDto;
import com.lobster.presenter.rest.entities.CharacteristicRequest;
import com.lobster.presenter.rest.entities.CharacteristicResponse;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/classification/characteristic")
@Validated
public interface CharacteristicResource {

    @PostMapping
    CompletableFuture<ResponseDto<CharacteristicResponse>> createCharacteristic(@RequestBody @Valid CharacteristicRequest characteristicRequest);

}
