package org.com.programming.application.domain.repository;

import org.com.programming.application.domain.aggregatesRoot.CustomerEntity;

import java.util.Optional;
import java.util.UUID;

// NOSSA INTERFACE PURA DIZENDO O NOSSO SISTEMA PRECISA.
public interface CustomerRepository {
    CustomerEntity save(CustomerEntity customer);
    Optional<CustomerEntity> findById(UUID id);
}
