package org.com.programming.application.domain.aggregate.root;
// Vai ser o nosso chefe do serviço

import jakarta.persistence.*;
import org.com.programming.application.domain.aggregate.entities.EngineEntity;

import java.util.UUID;

/* TODO - LEMBRANDO:
*   1.  protected CarRoot(): O hibernate exige um construtor para que ele consiga fazer a leitura do BD para você.
*   2.  public static CarRoot create(): A ideia é ser a única porta oficial para criarmos o nosso CARRO.
 */


@Entity
@Table(name = "tb_cars")
public class CarRoot {

    @Id
    private UUID uuid;
    private String modelName;
    private String brand;
    private boolean active;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "engine_id")
    private EngineEntity engine;

    protected CarRoot() {}

    private CarRoot(UUID uuid, String modelName, String brand, EngineEntity engine) {
        this.uuid = uuid;
        this.modelName = modelName;
        this.brand = brand;
        this.engine = engine;
        this.active = true;
    }

    public static CarRoot create(UUID id, String modelName, String brand, EngineEntity engine) {
        return new CarRoot(id, modelName, brand, engine);
    }

    public void disableActive() {
        this.active = false;
    }

    public UUID getUuid() { return uuid; }
    public String getModelName() { return modelName; }
    public String getBrand() { return brand; }
    public EngineEntity getEngine() { return engine; }
    public boolean isActive() { return active; }
}
