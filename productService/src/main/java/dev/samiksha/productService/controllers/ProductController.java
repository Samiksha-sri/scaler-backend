package dev.samiksha.productService.controllers;

import dev.samiksha.productService.dtos.GenericProductdto;
import dev.samiksha.productService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products/")
public class ProductController {

    private ProductService productService;

    public ProductController(@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public void getAllProducts(){

    }

    @GetMapping("{id}")
    public GenericProductdto getProductById(@PathVariable("id") Long id){

        return productService.getProductById(id);
    }

    @DeleteMapping("{id}")
    public void deleteProductById(){

    }

    @PostMapping
    public void createProduct(){

    }

    @PutMapping("{id}")
    public void updateProductById(){

    }
}
