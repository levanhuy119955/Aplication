package com.tmt.exception.reposiotry;

import com.tmt.exception.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductName(String productName);

    List<Product> findAllByPriceBetween(Double start, Double end);

    List<Product> findProductByPrice(Double price);

    List<Product> findByPrice(Double checkPrice);

    List<Product> findAllByProductNameEndingWith(String name);
}