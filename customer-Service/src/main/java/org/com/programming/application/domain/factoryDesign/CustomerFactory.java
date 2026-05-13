package org.com.programming.application.domain.factoryDesign;

import org.com.programming.application.domain.aggregatesRoot.CustomerEntity;
import org.com.programming.application.domain.valueObject.Email;

public class CustomerFactory  {

    public static CustomerEntity createWithDefaultSettings(String name, String emailStr){
        Email email = new Email(emailStr);

    }
}
