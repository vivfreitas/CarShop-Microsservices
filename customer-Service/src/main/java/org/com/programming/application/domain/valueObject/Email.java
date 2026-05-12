package org.com.programming.application.domain.valueObject;

/* Ele vai validar o nosso e-mail sozinho. */
public record Email(String address) {

    public Email{
        if (address == null || !address.contains("@")){
            try {
                throw new IllegalAccessException("Invalid email address");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } if (address.isBlank()){
            try {
                throw new IllegalAccessException("Address can't be blank.");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
