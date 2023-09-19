package dev.samiksha.productService.services;

import dev.samiksha.productService.dtos.GenericProductdto;
import dev.samiksha.productService.exceptions.NotFoundException;
import dev.samiksha.productService.models.Product;
import dev.samiksha.productService.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Primary
@Service
public class SelfProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    public SelfProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private GenericProductdto convertProductToGenericProduct(Product product){
        GenericProductdto genericProductdto = new GenericProductdto();
        genericProductdto.setId(product.getId());
        genericProductdto.setPrice(product.getPrice());
        genericProductdto.setDescription(product.getDescription());
        genericProductdto.setTitle(product.getTitle());
        genericProductdto.setImage(product.getImage());
        genericProductdto.setCategory(product.getCategory());

        return genericProductdto;
    }

    private Product convertGenericProductToProduct(GenericProductdto genericProductdto){
        Product product = new Product();
        product.setId(genericProductdto.getId());
        product.setPrice(genericProductdto.getPrice());
        product.setDescription(genericProductdto.getDescription());
        product.setTitle(genericProductdto.getTitle());
        product.setImage(genericProductdto.getImage());
        product.setCategory(genericProductdto.getCategory());


        return product;
    }

    @Override
    public GenericProductdto getProductById(Long id) throws NotFoundException {

        Product product = productRepository.findProductById(UUID.fromString(String.valueOf(id)));
        GenericProductdto genericProductdto = new GenericProductdto();
       genericProductdto =  convertProductToGenericProduct(product);
        return genericProductdto;
    }

    @Override
    public GenericProductdto createProduct(GenericProductdto genericProductdto) {

        Product product = new Product();
        product.setCategory(genericProductdto.getCategory());
        product.setId(genericProductdto.getId());
        product.setImage(genericProductdto.getImage());
        product.setDescription(genericProductdto.getDescription());
        product.setPrice(genericProductdto.getPrice());
        product.setTitle(genericProductdto.getTitle());
        productRepository.save(product);
        return genericProductdto;
    }

    @Override
    public GenericProductdto deleteProductById(Long id) {
        GenericProductdto genericProductdto = new GenericProductdto();
        Product product = productRepository.findProductById(UUID.fromString(String.valueOf(id)));
        genericProductdto = convertProductToGenericProduct(product);
     productRepository.deleteById(UUID.fromString(String.valueOf(id)));
        return genericProductdto;
    }

    @Override
    public GenericProductdto updateProductById(GenericProductdto productdto, Long id) {

        Product product = convertGenericProductToProduct(productdto);
        Product updatedProduct = productRepository.updateProductById(product, UUID.fromString(String.valueOf(id)));
        return convertProductToGenericProduct(updatedProduct);
    }

    @Override
    public List<GenericProductdto> getAllProducts() {

       List<Product> products = productRepository.findAllProducts();
       List<GenericProductdto> genericProductdtos = new ArrayList<>();
         if(products != null){
              for(Product product: products){
                  GenericProductdto genericProductdto = new GenericProductdto();
                  genericProductdto =  convertProductToGenericProduct(product);
                  genericProductdtos.add(genericProductdto);
              }

              }
        return genericProductdtos;
    }
}
