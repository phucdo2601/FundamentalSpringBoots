package com.phucdn.microservices.product.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.microservices.product.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
