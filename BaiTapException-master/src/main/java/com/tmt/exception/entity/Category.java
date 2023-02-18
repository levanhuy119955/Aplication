package com.tmt.exception.entity;

import com.mysql.cj.protocol.Message;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.websocket.OnMessage;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Bạn phải nhập tên loại sản phẩm")
    private String categoryName;

    @Column(length = 255)
    private String discription;


//    @OneToMany(mappedBy = "categoryID")
//    private List<Product> productList;
}
