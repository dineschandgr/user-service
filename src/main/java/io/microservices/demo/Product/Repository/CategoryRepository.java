package io.microservices.demo.Product.Repository;

import io.microservices.demo.Product.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
