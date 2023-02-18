package com.tmt.exception.exceptionentity;

import lombok.Data;

import java.util.Date;

@Data
public class ProductExceptionEntity {
    private Integer code;
    private String message;
    private Date timestamp;

}
