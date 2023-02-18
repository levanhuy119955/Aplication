package com.tmt.exception.service;

import com.tmt.exception.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product creatProduct(Product productNew);

    Product updateProduct(Integer id, Product productNew);

    Page<Product> getProducts();

    Product getProductID(Integer id);

    List<Product> getPrductByPriceBettween( String nameProduct);

    List<Product> getProductByPrice(Double price);

    void deleteProductById(Integer id);

    List<Product> getproductLikeEndName(String name);

    void deleteAllProduct();
}
