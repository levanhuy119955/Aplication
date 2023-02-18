package com.tmt.exception.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Bạn phải nhập tên sản phẩm")
    private String productName;

    @Column(length = 255, nullable = true)
    private String description;

    private double price;

    @Column(nullable = false)
    private String avatar;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category categoryID;

    @ManyToMany(mappedBy = "productList")
    @JsonIgnore
    private List<Order> productOrder;
}
