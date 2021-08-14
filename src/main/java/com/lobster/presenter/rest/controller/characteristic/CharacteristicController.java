package com.lobster.presenter.rest.controller.characteristic;

import com.lobster.core.usecase.UseCaseExecutor;
import com.lobster.core.usecase.characteristic.CreateCharacteristicUseCase;
import com.lobster.dto.ResponseDto;
import com.lobster.handler.ResponseHandler;
import com.lobster.presenter.rest.entities.CharacteristicRequest;
import com.lobster.presenter.rest.entities.CharacteristicResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;


@Component
@RequiredArgsConstructor
public class CharacteristicController implements CharacteristicResource {

    private final UseCaseExecutor useCaseExecutor;
    private final CreateCharacteristicUseCase createCharacteristicUseCase;

    @Override
    public CompletableFuture<ResponseDto<CharacteristicResponse>> createCharacteristic(CharacteristicRequest characteristicRequest) {
        return useCaseExecutor.execute(createCharacteristicUseCase, CreateCharacteristicInputMapper.map(characteristicRequest),
                outputValues -> ResponseHandler.execute(() ->
                        CharacteristicResponse.from(outputValues.getCharacteristic()), HttpStatus.CREATED)
        );
    }
}
