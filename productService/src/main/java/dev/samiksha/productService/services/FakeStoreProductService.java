package dev.samiksha.productService.services;

import dev.samiksha.productService.dtos.FakeStoreProductdto;
import dev.samiksha.productService.dtos.GenericProductdto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String productByIDURL = "https://fakestoreapi.com/products/{id}";
    private String productURL = "https://fakestoreapi.com/products";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
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
    public GenericProductdto getProductById(Long id) {
      RestTemplate restTemplate =  restTemplateBuilder.build();
      ResponseEntity<FakeStoreProductdto> responseEntity =
              restTemplate.getForEntity(productByIDURL, FakeStoreProductdto.class, id);

    FakeStoreProductdto fakeStoreProductdto = responseEntity.getBody();
        GenericProductdto genericProductdto = new GenericProductdto();

        genericProductdto.setTitle(fakeStoreProductdto.getTitle());
        genericProductdto.setPrice(fakeStoreProductdto.getPrice());
        genericProductdto.setCategory(fakeStoreProductdto.getCategory());
        genericProductdto.setDescription(fakeStoreProductdto.getDescription());
        genericProductdto.setImage(fakeStoreProductdto.getImage());

        return genericProductdto;
    }

    @Override
    public GenericProductdto createProduct(GenericProductdto productdto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductdto> responseEntity =
                restTemplate.postForEntity(productURL, productdto, GenericProductdto.class);

        GenericProductdto setProduct = responseEntity.getBody();

        return setProduct;
    }

    @Override
    public GenericProductdto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpEntity<GenericProductdto> request = new HttpEntity<GenericProductdto>(new GenericProductdto());
         ResponseEntity<GenericProductdto> responseEntity =
                 restTemplate.exchange(productByIDURL, HttpMethod.DELETE,
                         request, GenericProductdto.class,id);
        GenericProductdto deleteProduct = responseEntity.getBody();

        return deleteProduct;
    }

    @Override
    public GenericProductdto updateProductById(GenericProductdto genericProductdto, Long id) {
      RestTemplate restTemplate = restTemplateBuilder.build();
      RequestCallback requestCallback = restTemplate.httpEntityCallback(genericProductdto, FakeStoreProductdto.class);
      ResponseExtractor<ResponseEntity<FakeStoreProductdto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductdto.class);
      ResponseEntity<FakeStoreProductdto> responseEntity = restTemplate.execute(productByIDURL, HttpMethod.PUT,
              requestCallback, responseExtractor, id);
      FakeStoreProductdto fakeStoreProductdto = responseEntity.getBody();
        genericProductdto.setId(fakeStoreProductdto.getId());
          genericProductdto.setPrice(fakeStoreProductdto.getPrice());
          genericProductdto.setDescription(fakeStoreProductdto.getDescription());
          genericProductdto.setCategory(fakeStoreProductdto.getCategory());

        return genericProductdto;
    }

    @Override
    public List<GenericProductdto> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductdto[]> responseEntity = restTemplate.getForEntity(productURL, FakeStoreProductdto[].class);
        List<GenericProductdto> productdtos = new ArrayList<>();

        for(FakeStoreProductdto fakeStoreProductdto : responseEntity.getBody()){
            productdtos.add(convertFakeStoreProductToGenericProduct(fakeStoreProductdto));
        }
        return productdtos;
    }
}
