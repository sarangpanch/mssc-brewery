package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;

import java.util.UUID;

public interface CustomerService {

    CustomerDto getCustomer(UUID uuid);

    CustomerDto saveCustomer(CustomerDto customer);

    CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto);

    void deleteById(UUID customerId);
}
