package com.microtech.service.impl;

import com.microtech.model.Product;
import com.microtech.repository.ProductRepo;
import com.microtech.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepo;

    @Override
    public List<Product> getAllProductByCategoryId(int id) {
        return productRepo.findAllByCategory_Id(id);
    }

    @Override
    public Optional<Product> getProductById(long id) {
        return productRepo.findById(id);
    }

    @Override
    public void removeProductById(long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }
}
