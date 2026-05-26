package org.com.programming.application.domain.aggregate.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/* TODO:
*   1. ESSA CLASSE É EXCLUSIVA E ÚNICA APENAS COMO CLASSE FILHA PARA A ROOT.
*   2. 1 CARRO PODE TER AO MENOS 1 MOTOR.
* */

@Entity
@Table(name = "tb_engine")
public class EngineEntity {

    @Id
    private UUID uuid;
    private String serialNumber;
    private int horsepower;

    protected EngineEntity(){}

    public EngineEntity(UUID uuid, String serialNumber, int horsepower) {
        if (horsepower <= 0) {
            throw new IllegalArgumentException("Horsepower must be greater than 0");
        }
        if (serialNumber == null || serialNumber.isBlank()) {
            throw new IllegalArgumentException("Engine must have a valid serial number");
        }
        this.uuid = uuid;
        this.serialNumber = serialNumber;
        this.horsepower = horsepower;
    }

    public UUID getId() { return uuid; }
    public String getSerialNumber() { return serialNumber; }
    public int getHorsepower() { return horsepower; }
}
