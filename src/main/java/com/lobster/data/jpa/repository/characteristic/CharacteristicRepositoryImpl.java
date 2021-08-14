package com.lobster.data.jpa.repository.characteristic;

import com.lobster.core.domain.Characteristic;
import com.lobster.core.usecase.characteristic.CharacteristicRepository;
import com.lobster.data.jpa.entity.CharacteristicData;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CharacteristicRepositoryImpl implements CharacteristicRepository {
    private final CharacteristicJpaRepository repository;

    @Override
    public Characteristic persist(Characteristic characteristic) {
        final CharacteristicData characteristicData = CharacteristicData.from(characteristic);
        return repository.save(characteristicData).fromThis();
    }
}
