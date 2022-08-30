package com.thinhlh.project1.app.cart_item.data.service;

import com.thinhlh.project1.app.cart.domain.entity.Cart;
import com.thinhlh.project1.app.cart.domain.service.CartService;
import com.thinhlh.project1.app.cart_item.controller.dto.AddItemToCartRequest;
import com.thinhlh.project1.app.cart_item.controller.dto.CartItemResponse;
import com.thinhlh.project1.app.cart_item.controller.dto.GetCartItemsRequest;
import com.thinhlh.project1.app.cart_item.data.repository.CartItemMybasticRepository;
import com.thinhlh.project1.app.cart_item.data.repository.CartItemRepository;
import com.thinhlh.project1.app.cart_item.domain.entity.CartItem;
import com.thinhlh.project1.app.cart_item.domain.entity.CartItemKey;
import com.thinhlh.project1.app.cart_item.domain.service.CartItemService;
import com.thinhlh.project1.app.customer.domain.service.CustomerService;
import com.thinhlh.project1.app.product.domain.entity.Product;
import com.thinhlh.project1.app.product.domain.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    @Resource
    private final CartItemMybasticRepository cartItemMybasticRepository;
    private final CartService cartService;
    private final ProductService productService;
    private final CustomerService customerService;


    @Override
    public Boolean addCartItemToCart(AddItemToCartRequest request) {

        Cart cart = cartService.findByCustomerId(request.getCustomerId());


        cartItemRepository.saveAll(
                request
                        .getItems()
                        .stream()
                        .map(item ->
                                getCartItem(cart, productService.getProductById(item.getProductId()), item.getQuantity())
                        )
                        .toList());


        return true;
    }

    private CartItem getCartItem(Cart cart, Product product, Long quantity) {

        CartItem cartItem = cartItemRepository.findByCart_IdAndProduct_Id(cart.getId(), product.getId());

        if (cartItem == null) {
            CartItemKey cartItemKey = new CartItemKey(cart.getId(), product.getId());

            cartItem = new CartItem();
            cartItem.setId(cartItemKey);

            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setDateAdded(Date.from(Instant.now()));
            cartItem.setQuantityWished(0L);
        }
        var newQuantity = cartItem.getQuantityWished() + quantity;

        cartItem.setQuantityWished(newQuantity);
        cartItem.setTotalAmount(BigDecimal.valueOf(product.getPrice() * newQuantity));

        return cartItem;
    }

    @Override
    public List<CartItemResponse> getCartItems(GetCartItemsRequest request) {
        return cartItemMybasticRepository
                .findAllByCart_Customer_IdAndProduct_Name(
                        request.getCustomerId(),
                        request.getProductName(),
                        request.getLimit(),
                        request.getOffset()
                );
    }
}
