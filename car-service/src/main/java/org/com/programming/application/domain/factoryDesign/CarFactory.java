package org.com.programming.application.domain.factoryDesign;

import org.com.programming.application.domain.aggregate.root.CarRoot;
import org.com.programming.application.domain.aggregate.entities.EngineEntity;

import java.util.UUID;
/* TODO:
*   1. A camada de carro não pode ser criada sem um motor então, usamos um fabrica de carros para montar um.
*   2. A principal função de uma Factory dentro da pasta domain é isolar a complexidade de criação de um Aggregate Root.
*   Sendo assim, aqui usamos o Simple Factory. */

public class CarFactory {

    public static CarRoot createNewCar(String modelName, String brand, String serialNumber, int horsepower){
        // Nossos IDs random para as nossas classes.
        UUID carId = UUID.randomUUID();
        UUID engineId = UUID.randomUUID();

        EngineEntity engine = new EngineEntity(engineId, serialNumber, horsepower);
        return CarRoot.create(carId, modelName, brand, engine);

    }
}

/* TODO:
    SIMPLES FACTORY: padrão de projeto criacional que centraliza a lógica de criação de objetos.
    Em vez de espalhar comandos de instanciação (como new) pelo código,
    você delega essa responsabilidade a uma classe específica (a "fábrica"), que decide qual classe
    instanciar com base em parâmetros fornecidos*/
