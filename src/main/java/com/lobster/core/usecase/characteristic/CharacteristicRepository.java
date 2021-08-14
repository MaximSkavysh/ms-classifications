package com.lobster.core.usecase.characteristic;

import com.lobster.core.domain.Characteristic;

public interface CharacteristicRepository {
    Characteristic persist(Characteristic characteristic);
}
