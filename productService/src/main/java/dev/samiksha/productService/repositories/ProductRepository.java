package dev.samiksha.productService.repositories;

import dev.samiksha.productService.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>{

   Product findProductById(UUID id);

   @Query(value = "UPDATE Product p SET p.title = ?2, p.description = ?3, p.price = ?4, p.image = ?5, p.category = ?6 WHERE p.id = ?1",
           nativeQuery = true)
  Product updateProductById(Product product, UUID id);

   @Query(value = "SELECT * FROM Product p", nativeQuery = true)
   List<Product> findAllProducts();
}
