package dev.samiksha.productService.services;

import dev.samiksha.productService.productServiceClients.FakeStoreProductServiceClient;
import dev.samiksha.productService.productServiceClients.FakeStoreProductdto;
import dev.samiksha.productService.dtos.GenericProductdto;
import dev.samiksha.productService.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Repository("fakeStoreProductService")
public class  FakeStoreProductService implements ProductService{

    private FakeStoreProductServiceClient fakeStoreProductServiceClient;
    public FakeStoreProductService(FakeStoreProductServiceClient fakeStoreProductServiceClient){
        this.fakeStoreProductServiceClient = fakeStoreProductServiceClient;
    }

    private GenericProductdto convertFakeStoreProductToGenericProduct(FakeStoreProductdto fakeStoreProductdto){
        GenericProductdto genericProductdto = new GenericProductdto();
        genericProductdto.setId(fakeStoreProductdto.getId());
        genericProductdto.setPrice(fakeStoreProductdto.getPrice());
        genericProductdto.setDescription(fakeStoreProductdto.getDescription());
        genericProductdto.setTitle(fakeStoreProductdto.getTitle());
        genericProductdto.setImage(fakeStoreProductdto.getImage());
        genericProductdto.setCategory(fakeStoreProductdto.getCategory());

        return genericProductdto;
    }

    @Override
    public GenericProductdto getProductById(Long id) throws NotFoundException {


        return convertFakeStoreProductToGenericProduct(fakeStoreProductServiceClient.getProductById(id));
    }

    @Override
    public GenericProductdto createProduct(GenericProductdto productdto) {

        return convertFakeStoreProductToGenericProduct(fakeStoreProductServiceClient.createProduct(productdto));
    }

    @Override
    public GenericProductdto deleteProductById(Long id) {

        return convertFakeStoreProductToGenericProduct(fakeStoreProductServiceClient.deleteProductById(id));
    }

    @Override
    public GenericProductdto updateProductById(GenericProductdto genericProductdto, Long id) {

        return convertFakeStoreProductToGenericProduct(fakeStoreProductServiceClient.updateProductById(genericProductdto, id));
    }

    @Override
    public List<GenericProductdto> getAllProducts() {

        List<GenericProductdto> productdtos = new ArrayList<>();

        for(FakeStoreProductdto fakeStoreProductdto : fakeStoreProductServiceClient.getAllProducts()){
            productdtos.add(convertFakeStoreProductToGenericProduct(fakeStoreProductdto));
        }
        return productdtos;
    }
}
