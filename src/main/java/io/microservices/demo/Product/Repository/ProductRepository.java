package io.microservices.demo.Product.Repository;

import io.microservices.demo.Product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Optional<Product> findByUserId(Long id);

}
