package com.thinhlh.project1.app.cart_item.data.repository;

import com.thinhlh.project1.app.cart_item.domain.entity.CartItem;
import com.thinhlh.project1.app.cart_item.domain.entity.CartItemKey;
import com.thinhlh.project1.app.product.domain.entity.Product;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, CartItemKey> {
    CartItem findByCart_IdAndProduct_Id(Long cartId, Long productId);

    @Query(value = "SELECT CAI.* \n" +
            "FROM CART_ITEM CAI jOIN CART C on C.CART_ID  = CAI.CART_ID  \n" +
            "join CUSTOMER CU on CU.CUSTOMER_ID = C.CART_ID \n" +
            "join PRODUCT P on P.product_id = CAI.PRODUCT_ID \n" +
            "WHERE CU.CUSTOMER_ID = ?1 and P.name_product = ?2 ",
            nativeQuery = true,
            countQuery = "SELECT COUNT(*) \n" +
                    "FROM CART_ITEM CAI jOIN CART C on C.CART_ID  = CAI.CART_ID  \n" +
                    "join CUSTOMER CU on CU.CUSTOMER_ID = C.CART_ID \n" +
                    "join PRODUCT P on P.product_id = CAI.PRODUCT_ID \n" +
                    "WHERE CUSTOMER_ID=?1 and P.name_product = ?2 ")
    List<CartItem> findAllByCart_Customer_IdAndProduct_Name(Long id, String name, Pageable pageable);
}
