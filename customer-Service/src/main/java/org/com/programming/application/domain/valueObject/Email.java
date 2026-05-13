package org.com.programming.application.domain.valueObject;

import jakarta.persistence.Embeddable;


// Como o nosso ValueObject não é uma classe de identidade, usamos o @Embeddable para embutir a mesma na nossa entity.
// A NOSSA TABELA SÓ VAI QUERER SABER DE RECEBER O ADDRESS E NÃO SE IMPORTANDO COM A LÓGICA DO NEGÓCIO.
@Embeddable
public record Email(String address) {
    public Email{
        if (address == null || !address.matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("Invalid e-mail format");
        } if (address.isBlank()){
            throw new IllegalArgumentException("E-mail cannot be empty or blank");
        }
    }
}
