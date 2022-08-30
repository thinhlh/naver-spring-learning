package com.thinhlh.project1.app.customer.data.service;

import com.thinhlh.project1.app.cart.domain.entity.Cart;
import com.thinhlh.project1.app.customer.data.repository.CustomerRepository;
import com.thinhlh.project1.app.customer.domain.entity.Customer;
import com.thinhlh.project1.app.customer.domain.service.CustomerService;
import com.thinhlh.project1.config.constants.MessageConstants;
import com.thinhlh.project1.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer getCustomerById(Long customerId) {
        var customer = customerRepository.findById(customerId);

        if (customer.isEmpty()) throw new NotFoundException(MessageConstants.CUSTOMER_NOT_FOUND);
        return customer.get();
    }

    @Override
    public Cart getCartByCustomerId(Long customerId) {
        var customer = getCustomerById(customerId);

        if (customer.getCart() == null) {
            var cart = new Cart();
            customer.setCart(cart);
            cart.setCustomer(customer);

            return customerRepository.save(customer).getCart();
        } else {
            return customer.getCart();
        }
    }
}
