package com.mrleanage.webserver.repository;

import com.mrleanage.webserver.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
