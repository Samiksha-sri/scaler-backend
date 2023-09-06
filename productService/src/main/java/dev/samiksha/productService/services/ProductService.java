package dev.samiksha.productService.services;

import dev.samiksha.productService.dtos.FakeStoreProductdto;
import dev.samiksha.productService.dtos.GenericProductdto;
import dev.samiksha.productService.models.Product;

public interface ProductService {

     GenericProductdto getProductById(Long id);

     GenericProductdto createProduct(GenericProductdto productdto);

     GenericProductdto deleteProductById(Long id);
}
