package com.productcategory.Service;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.productcategory.Repository.ProductsRepository;
import com.productcategory.model.products;

@Service
public class ProductService {

	
	@Autowired
    private ProductsRepository productRepository;

    public Page<products> getAllProducts(PageRequest pageable) {
        return productRepository.findAll(pageable);
    }

    public products saveProduct(products product) {
        return productRepository.save(product);
    }

    public Optional<products> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }
}
