package com.thinhlh.project1.app.cart.data.service;


import com.thinhlh.project1.app.cart.data.repository.CartRepository;
import com.thinhlh.project1.app.cart.domain.entity.Cart;
import com.thinhlh.project1.app.cart.domain.service.CartService;
import com.thinhlh.project1.app.customer.data.repository.CustomerRepository;
import com.thinhlh.project1.app.customer.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final CustomerRepository customerRepository;

    private final CustomerService customerService;

    @Override
    public Cart findByCustomerId(Long customerId) {
        Optional<Cart> cartOptional = cartRepository.findByCustomer_Id(customerId);

        if (cartOptional.isEmpty()) {
            Cart newCart = new Cart();
            newCart.setCustomer(customerService.getCustomerById(customerId));

            return cartRepository.save(newCart);
        } else {
            return cartOptional.get();
        }
    }
}
