package org.com.programming.application.infrastructure.persistence;

import org.com.programming.application.domain.aggregate.root.CarRoot;
import org.com.programming.application.domain.repository.CarRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JpaCarRepository extends JpaRepository<CarRoot, UUID>, CarRepository {

    /* TODO:
    *   1. O Spring Data é quem vai implementar a nossa interface CustomerRepository aqui.
    *   2. Dentro do próprio JpaRepository, ele já tem métodos como save e findByID.
    *   3. Perceba que o nosso DOMAIN agora está isolado e sem contato com a camada de infra.*/

}
