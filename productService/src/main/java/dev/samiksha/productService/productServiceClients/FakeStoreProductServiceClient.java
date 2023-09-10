package dev.samiksha.productService.productServiceClients;

import dev.samiksha.productService.dtos.GenericProductdto;
import dev.samiksha.productService.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductServiceClient {
    private RestTemplateBuilder restTemplateBuilder;
    @Value("${fakestore.api.url}")
    private String fakeStoreApiUrl;
    @Value("${fakestore.api.paths.product}")
    private String fakeStoreProductsApiPath;
    private String specificProductRequestUrl ;
    private String productRequestBaseUrl ;
    public FakeStoreProductServiceClient(RestTemplateBuilder restTemplateBuilder, @Value("${fakestore.api.url}") String fakeStoreApiUrl,
                                         @Value("${fakestore.api.paths.product}") String fakeStoreProductsApiPath){
        this.restTemplateBuilder = restTemplateBuilder;
        this.productRequestBaseUrl = fakeStoreApiUrl + fakeStoreProductsApiPath;
        this.specificProductRequestUrl = fakeStoreApiUrl + fakeStoreProductsApiPath + "/{id}";
    }

    public FakeStoreProductdto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate =  restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductdto> responseEntity =
                restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductdto.class, id);

        FakeStoreProductdto fakeStoreProductdto = responseEntity.getBody();

        if(fakeStoreProductdto == null)
            throw new NotFoundException("Product with id  " + id + "not found");

        return fakeStoreProductdto;
    }

    public FakeStoreProductdto createProduct(GenericProductdto productdto) {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductdto> responseEntity =
                restTemplate.postForEntity(productRequestBaseUrl, productdto, FakeStoreProductdto.class);

        return responseEntity.getBody();
    }

    public FakeStoreProductdto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductdto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductdto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductdto.class);
        ResponseEntity<FakeStoreProductdto> responseEntity = restTemplate.execute(specificProductRequestUrl, HttpMethod.DELETE, requestCallback, responseExtractor,id);
        FakeStoreProductdto fakeStoreProductdto = responseEntity.getBody();

        return fakeStoreProductdto;
    }

    public FakeStoreProductdto updateProductById(GenericProductdto genericProductdto, Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.httpEntityCallback(genericProductdto, FakeStoreProductdto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductdto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductdto.class);
        ResponseEntity<FakeStoreProductdto> responseEntity = restTemplate.execute(specificProductRequestUrl, HttpMethod.PUT,
                requestCallback, responseExtractor, id);
        FakeStoreProductdto fakeStoreProductdto = responseEntity.getBody();


        return fakeStoreProductdto;
    }

    public List<FakeStoreProductdto> getAllProducts() {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductdto[]> responseEntity = restTemplate.getForEntity(productRequestBaseUrl, FakeStoreProductdto[].class);
        List<FakeStoreProductdto> productdtos = new ArrayList<>();

        for(FakeStoreProductdto fakeStoreProductdto : responseEntity.getBody()){
            productdtos.add(fakeStoreProductdto);
        }
        return productdtos;
    }
}
