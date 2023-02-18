package com.tmt.exception.servicesimpl;

import com.tmt.exception.entity.Product;
import com.tmt.exception.global.ProductExceptionGlobal;
import com.tmt.exception.reposiotry.ProductRepository;
import com.tmt.exception.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ProductImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;


    @Override
    public Product creatProduct(Product productNew){
        Optional<Product> checkName= productRepository.findByProductName(productNew.getProductName());
        if (checkName == null){
            Product product = productRepository.save(productNew);
        }else {
         throw new ProductExceptionGlobal("Đã có sản phẩm tên " + productNew.getProductName() + ", Bạn thử lại nhé!");
        }
        return productNew;
    }

    @Override
    public Product updateProduct(Integer id, Product productNew) {
        // Lấy ra ID nếu có hoặc ném ra ngoại lệ
        Product checkID = productRepository.findById(id).orElseThrow(() -> new ProductExceptionGlobal("Không có ID " + id +", Bạn thử lại!"));
            Product proID = new Product();
            proID.setId(productNew.getId());
            proID.setProductName(productNew.getProductName());
            proID.setDescription(productNew.getDescription());
            proID.setPrice(productNew.getPrice());
            proID.setAvatar(productNew.getAvatar());
            proID.setCategoryID(productNew.getCategoryID());
            productRepository.save(proID);

        return productNew;
    }

    @Override
    public Page<Product> getProducts() {
        Sort sort = Sort.by("id").ascending(); // Sắp xếp theo ID tăng dần
        Pageable pageable = PageRequest.of(0, 5, sort);
        Page<Product> products = productRepository.findAll(pageable);
        return products;
    }

    @Override
    public Product getProductID(Integer id) {
        return productRepository.findById(id).orElseThrow(() ->
                new ProductExceptionGlobal("Không có ID " + id + ", Bạn thử lại!"));
    }

    @Override
    public List<Product> getPrductByPriceBettween(String nameProduct) {
       List<Product> products = productRepository.findAllByPriceBetween(100.5, 500.7);
        return products;
    }

    @Override
    public List<Product> getProductByPrice(Double price) {
      List<Product> checkPrice = productRepository.findByPrice(price);
      if (checkPrice.isEmpty()){
          throw new ProductExceptionGlobal("Không có sản phẩm nào có giá " + price + ", Bạn thử lại!");
      }
      List<Product> productList = productRepository.findProductByPrice(price);
        return productList;
    }

    @Override
    public void deleteProductById(Integer id) {
       Product checkId = productRepository.findById(id).orElseThrow(() -> new ProductExceptionGlobal("Không có sản phẩm nào có ID " + id + ", ban thử lại!"));
        this.productRepository.deleteById(id);
    }

    @Override
    public List<Product> getproductLikeEndName(String name) {
        List<Product> product = productRepository.findAllByProductNameEndingWith(name);
        return product;
    }

    @Override
    public void deleteAllProduct() {
        this.productRepository.deleteAll();
    }


}
