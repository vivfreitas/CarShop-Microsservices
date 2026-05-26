package org.com.programming.application.domain.repository;

import org.com.programming.application.domain.aggregate.root.CarRoot;

import java.util.Optional;
import java.util.UUID;

// NOSSA INTERFACE PURA DIZENDO O NOSSO SISTEMA PRECISA.
public interface CarRepository {
    CarRoot save(CarRoot customer);
    Optional<CarRoot> findById(UUID id);
}
