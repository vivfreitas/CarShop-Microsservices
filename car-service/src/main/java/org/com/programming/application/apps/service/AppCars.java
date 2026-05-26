package org.com.programming.application.apps.service;

import org.com.programming.application.domain.aggregate.root.CarRoot;
import org.com.programming.application.domain.factoryDesign.CarFactory;
import org.com.programming.application.domain.repository.CarRepository;
import org.springframework.stereotype.Service;

@Service
public class AppCars {
    private final CarRepository customerRepository;

    public AppCars(CarRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void createNewCostumer(String name, String email){
        CarRoot newCustomer = CarFactory.createWithDefaultSettings(name, email);
        customerRepository.save(newCustomer);
    }
}
