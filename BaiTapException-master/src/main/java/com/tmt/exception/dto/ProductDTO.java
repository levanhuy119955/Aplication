package com.tmt.exception.dto;

import com.tmt.exception.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private int id;
    private String productName;
    private double price;
    private String avatar;
    private String discription;
    private Category categoryID;
}
