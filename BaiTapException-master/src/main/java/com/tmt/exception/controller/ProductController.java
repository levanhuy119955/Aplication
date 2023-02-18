package com.tmt.exception.controller;

import com.tmt.exception.entity.Product;
import com.tmt.exception.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    // Thêm mới sản phẩm
    @PostMapping("/creatProduct")
    public ResponseEntity<Product> creatProduct(@Validated @RequestBody Product product){
        Product product1 = productService.creatProduct(product);
        return ResponseEntity.ok(product1);
    }
    // Update thông tin sản phẩm theo ID
    @PutMapping("/newProduct/{id}")
    public ResponseEntity<Product> replaceProduct(@Validated @PathVariable Integer id, @RequestBody Product productNew){
        Product product2 = productService.updateProduct(id, productNew);
        return ResponseEntity.ok(product2);
    }
    // Lấy ra tất cả sản phẩm
    @GetMapping("/allProduct")
    public Page<Product> getAllProducts(){
        Page<Product> productList = productService.getProducts();
        return productList;
    }
    // Lấy ra sản phẩm theo id
    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> getProductID(@PathVariable (name = "id") Integer id){
        Product product3 = productService.getProductID(id);
        return ResponseEntity.ok(product3);
    }
    // Lấy ra sản phẩm áo xịn có giá từ 100.5 - 500.7
    @GetMapping("/getPriceBettween")
    public List<Product> getProductByPrice(@RequestParam (name = "ao_xin") String name){
        List<Product> product4 = productService.getPrductByPriceBettween(name);
        return product4;
    }
    // Lấy ra sản phẩm theo giá nhập vào
    @GetMapping("/getProductByPrice")
    public List<Product> getProductPrice(@RequestParam (name = "price") Double price){
        List<Product> product5 = productService.getProductByPrice(price);
        return product5;
    }
//    // Lấy ra danh sách sản phẩm theo tên sản phầm kết thúc bằng "lụa"
//    @GetMapping("/getEndName")
//    public ResponseEntity<List<Product>> getPrductEndName(@RequestParam (name = "lua") String name){
//        List<Product> product6 = productService.getproductLikeEndName(name);
//        return ResponseEntity.ok(product6);
//    }
    // Xóa sản phẩm theo ID
    @DeleteMapping("/deleteProduct/{id}")
    public String deleteProductId(@PathVariable Integer id){
        this.productService.deleteProductById(id);
        return "Thành công";
    }

    @DeleteMapping("/deleteAllProduct")
    public String deleteAllProduct(){
        this.productService.deleteAllProduct();
        return "Thành công";
    }
}
