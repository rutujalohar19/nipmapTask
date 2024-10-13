package com.productcategory.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productcategory.Service.ProductService;
import com.productcategory.model.products;

@RestController
@RequestMapping("/api/products")
public class ProductsController {
	 @Autowired
	    private ProductService productService;

	    @GetMapping
	    public Page<products> getAllProducts(@RequestParam int page, @RequestParam int size) {
	        return productService.getAllProducts(PageRequest.of(page, size));
	    }

	    @PostMapping
	    public products createProduct(@RequestBody products product) {
	        return productService.saveProduct(product);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<products> getProductById(@PathVariable Long id) {
	        Optional<products> product = productService.getProductById(id);
	        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<products> updateProduct(@PathVariable Long id, @RequestBody products product) {
	        Optional<products> existingProduct = productService.getProductById(id);
	        if (existingProduct.isPresent()) {
	            product.setId(id);
	            return ResponseEntity.ok(productService.saveProduct(product));
	        }
	        return ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
	        productService.deleteProductById(id);
	        return ResponseEntity.ok().build();
	    }

}
