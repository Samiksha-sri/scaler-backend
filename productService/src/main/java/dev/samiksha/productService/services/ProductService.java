package dev.samiksha.productService.services;

import dev.samiksha.productService.dtos.GenericProductdto;
import dev.samiksha.productService.exceptions.NotFoundException;

import java.util.List;

public interface ProductService {

     GenericProductdto getProductById(Long id) throws NotFoundException;

     GenericProductdto createProduct(GenericProductdto productdto);

     GenericProductdto deleteProductById(Long id);

     GenericProductdto updateProductById( GenericProductdto productdto, Long id);

     List<GenericProductdto> getAllProducts();
}
