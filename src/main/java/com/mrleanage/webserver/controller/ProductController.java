package com.mrleanage.webserver.controller;

import com.mrleanage.webserver.exception.ResourceNotFoundException;
import com.mrleanage.webserver.model.Product;
import com.mrleanage.webserver.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    /**
     * @return All Products
     */
    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    /**
     * method to get specific product by ID
     * @param id product id
     * @return specific product object
     */
    @GetMapping("{id}")
    public ResponseEntity<Product> getSpecificProductById(@PathVariable long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product Not Exist with id : " +id));

        return ResponseEntity.ok(product);
    }

    /**
     * Adding a new Product to database
     * @param product get the new product from client Side
     * @return returning added product
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    /**
     * updating existing product
     * @param id product id
     * @param product product details
     * @return updated product details
     */
    @PutMapping("{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable long id, @RequestBody Product product){
        Product updatingProduct = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found for id : " +id));
        updatingProduct.setName(product.getName());
        updatingProduct.setDescription(product.getDescription());
        updatingProduct.setPrice(product.getPrice());
        updatingProduct.setExpireDate(product.getExpireDate());

        productRepository.save(updatingProduct);

        return ResponseEntity.ok(updatingProduct);
    }

    /**
     * deleting a product by Id
     * @param id of the product that need to delete
     * @return returning Http response status for existence of deleted product
     */
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable long id){
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found for id : " +id));

        productRepository.delete(product);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
