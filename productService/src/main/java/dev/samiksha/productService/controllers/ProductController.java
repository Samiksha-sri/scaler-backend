package dev.samiksha.productService.controllers;

import dev.samiksha.productService.dtos.GenericProductdto;
import dev.samiksha.productService.exceptions.NotFoundException;
import dev.samiksha.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products/")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<GenericProductdto> getAllProducts(){

        return productService.getAllProducts();

    }

    @GetMapping("{id}")
    public ResponseEntity<GenericProductdto> getProductById(@PathVariable("id") Long id) throws NotFoundException {

        return new ResponseEntity<>(
                productService.getProductById(id),
                HttpStatus.OK
        );

    }

    @DeleteMapping("{id}")
    public GenericProductdto deleteProductById(@PathVariable("id") Long id){

      return  productService.deleteProductById(id);

    }

    @PostMapping
    public GenericProductdto createProduct(@RequestBody GenericProductdto product){

        return productService.createProduct(product);
    }

    @PutMapping("{id}")
    public GenericProductdto updateProductById( @RequestBody GenericProductdto productdto, @PathVariable("id") Long id){
        return productService.updateProductById(productdto, id);

    }
}
