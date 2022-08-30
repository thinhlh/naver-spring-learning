package com.thinhlh.project1.app.cart_item.data.repository;

import com.thinhlh.project1.app.cart_item.controller.dto.CartItemResponse;
import com.thinhlh.project1.app.cart_item.domain.entity.CartItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Mapper
public interface CartItemMybasticRepository {

    @Select(value = "SELECT CAI.* " +
            "FROM CART_ITEM CAI jOIN CART C on C.CART_ID  = CAI.CART_ID " +
            "JOIN CUSTOMER CU on CU.CUSTOMER_ID = C.CART_ID " +
            "JOIN PRODUCT P on P.PRODUCT_ID = CAI.PRODUCT_ID " +
            "WHERE CU.CUSTOMER_ID = #{id} and P.NAME_PRODUCT = #{name}" +
            "LIMIT #{limit} " +
            "OFFSET #{offset}")
    @Results(
            value = {
                    @Result(property = "productId", column = "product_id"),
                    @Result(property = "cartId", column = "cart_id"),
                    @Result(property = "quantity", column = "quantity_wished"),
                    @Result(property = "totalAmount", column = "total_amount"),
                    @Result(property = "dateAdded", column = "date_added"),

            }
    )
    List<CartItemResponse> findAllByCart_Customer_IdAndProduct_Name(Long id, String name, Long limit, Long offset);
}
