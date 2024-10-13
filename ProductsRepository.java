package com.productcategory.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.productcategory.model.products;

@Repository
public interface ProductsRepository extends JpaRepository<products, Long> {

}
