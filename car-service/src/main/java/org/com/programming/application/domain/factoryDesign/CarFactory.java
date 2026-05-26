package org.com.programming.application.domain.factoryDesign;

import org.com.programming.application.domain.aggregatesRoot.CustomerEntity;
import org.com.programming.application.domain.valueObject.Email;
import java.util.UUID;

public class CustomerFactory  {

    public static CustomerEntity createWithDefaultSettings(String name, String emailStr){
        Email email = new Email(emailStr); // E-mail sendo verificado.
        UUID uuid = UUID.randomUUID(); // Dando um ID aleatório.
        return CustomerEntity.create(uuid, name, email); // Criando o nosso próprio usuário.
    }
}
