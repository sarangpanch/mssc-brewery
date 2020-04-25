package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDto getCustomer(UUID uuid) {
        return CustomerDto.builder().id(uuid).name("Sarang").build();
    }

    @Override
    public CustomerDto saveCustomer(CustomerDto customer) {
        return CustomerDto.builder().id(UUID.randomUUID()).name("Sarang").build();
    }

    @Override
    public CustomerDto updateCustomer(UUID customerId, CustomerDto customerDto) {
        log.info("customer is updated:" + customerDto.getId());
        return CustomerDto.builder().id(customerId).name(customerDto.getName()).build();
    }

    @Override
    public void deleteById(UUID customerId) {
        log.info("Customer deleted:"+ customerId.toString());
    }
}
