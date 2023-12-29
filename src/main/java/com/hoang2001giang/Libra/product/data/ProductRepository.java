package com.hoang2001giang.Libra.product.data;

import com.hoang2001giang.Libra.category.data.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, String> {
    Optional<Product> findFirstBySlugAndCategory(String slug, Category category);
}
