package dev.samiksha.productService.services;

import dev.samiksha.productService.dtos.GenericProductdto;
import dev.samiksha.productService.models.Product;

public interface ProductService {

     GenericProductdto getProductById(Long id);
}
