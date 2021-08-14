package com.lobster.data.jpa.repository.characteristic;

import com.lobster.data.jpa.entity.CharacteristicData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicJpaRepository extends JpaRepository<CharacteristicData, Long> {
}
