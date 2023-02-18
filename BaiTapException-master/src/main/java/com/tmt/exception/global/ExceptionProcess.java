package com.tmt.exception.global;

import com.tmt.exception.exceptionentity.CategoryExceptionEntity;
import com.tmt.exception.exceptionentity.ProductExceptionEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class ExceptionProcess {


    @ExceptionHandler(value = ProductExceptionGlobal.class)
    public ResponseEntity<Object> productException (ProductExceptionGlobal productExceptionGlobal){
        ProductExceptionEntity productEx = new ProductExceptionEntity();
        productEx.setCode(100);
        productEx.setMessage(productExceptionGlobal.getMessage());
        productEx.setTimestamp(new Date());
        return new ResponseEntity<>(productEx, HttpStatus.BAD_REQUEST);
    }
//    @ExceptionHandler (value = ExceptionGlobal.class)
//    public Map<Object,String> mapExxception(ExceptionGlobal excepGlobal){
//        CategoryExceptionEntity categoryEx = new CategoryExceptionEntity();
//        Map<Object,String> maps = new HashMap<>();
//
//        maps.put(categoryEx.getCode(),"04105");
//        maps.put(categoryEx.getMessage(),"Category name độ dài phải lớn hơn 5");
//        maps.put(categoryEx.getTimestamp().toString(),"");
//
//        return maps;
//    }
}
