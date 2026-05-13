package org.com.programming.application.domain.aggregatesRoot;
// Vai ser o nosso chefe do serviço

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.antlr.v4.runtime.misc.NotNull;
import org.com.programming.application.domain.valueObject.Email;
import java.util.UUID;

/* TODO - LEMBRANDO:
*   1.  protected CustomerEntity(): O hibernate exige um construtor para que ele consiga fazer a leitura do BD para você.
*   2.  private CustomerEntity(): Será usado exclusivamente para o uso do Factory Method.
*   3.  public static CustomerEntity create(): A ideia é ser a única porta oficial para criarmos o nosso usuário.
*   4.  private Email email: Usamos a composição aqui para dizer que um usuário tem um E-mail sem se importar com a lógica por trás dele */


@Entity
@Table(name = "tb_customer")
public class CustomerEntity {

    @Id
    private UUID uuid;

    private String name;

    @Embedded
    private Email email;

    private boolean active;


    protected CustomerEntity(){}

    private CustomerEntity(UUID uuid, String name, Email email) {
        this.uuid = uuid;
        this.name = name;
        this.email = email;
        this.active = true; // Aqui é só para dizer que novos usuários sempre estarão ativos.
    }

    public static CustomerEntity create(UUID id, String name, Email email) {
        return new CustomerEntity(id, name, email);
    }

    public void disableActive(){
        this.active = false;
    }

    // Como temos apenas uma regra para o nome, é valido que use a regra de negócio aqui. Caso ao contrário, ValueObject.
    public void updateName(String newName){
        // Se a condição for verdadeira ela cai aqui.
        if (newName == null || newName.isBlank()){
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = newName;
    }

    public UUID getUuid() {return uuid;}
    public String getName() {return name;}
    public Email getEmail() {return email;}

    public boolean isActive() {return active;}
}
