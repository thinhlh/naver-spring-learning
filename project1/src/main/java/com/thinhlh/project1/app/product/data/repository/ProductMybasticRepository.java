package com.thinhlh.project1.app.product.data.repository;

import com.thinhlh.project1.app.product.domain.entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductMybasticRepository {


    @Select("SELECT * FROM PRODUCT WHERE price < #{price}")
    @Results(
            value = {
                    @Result(property = "id", column = "product_id"),
                    @Result(property = "name", column = "name_product")
            }
    )
    List<Product> findAllByPriceLessThan(Double price);

    @Select("SELECT * FROM PRODUCT WHERE price > #{price}")
    @Results(
            value = {
                    @Result(property = "id", column = "product_id"),
                    @Result(property = "name", column = "name_product")
            }
    )
    List<Product> findAllByPriceGreaterThan(Double price);

    @Select("SELECT * FROM PRODUCT WHERE price = #{price}")
    @Results(
           value = {
                   @Result(property = "id", column = "product_id"),
                   @Result(property = "name", column = "name_product")
           }
    )
    List<Product> findAllByPriceEquals(Double price);
}
