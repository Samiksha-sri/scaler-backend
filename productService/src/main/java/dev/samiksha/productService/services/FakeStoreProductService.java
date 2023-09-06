package dev.samiksha.productService.services;

import dev.samiksha.productService.dtos.FakeStoreProductdto;
import dev.samiksha.productService.dtos.GenericProductdto;
import dev.samiksha.productService.models.Product;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private RestTemplateBuilder restTemplateBuilder;
    private String getProductRequestURL = "https://fakestoreapi.com/products/{id}";
    public FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }

    @Override
    public GenericProductdto getProductById(Long id) {
      RestTemplate restTemplate =  restTemplateBuilder.build();
      ResponseEntity<FakeStoreProductdto> responseEntity =
              restTemplate.getForEntity(getProductRequestURL, FakeStoreProductdto.class, id);

    FakeStoreProductdto fakeStoreProductdto = responseEntity.getBody();
        GenericProductdto genericProductdto = new GenericProductdto();

        genericProductdto.setTitle(fakeStoreProductdto.getTitle());
        genericProductdto.setPrice(fakeStoreProductdto.getPrice());
        genericProductdto.setCategory(fakeStoreProductdto.getCategory());
        genericProductdto.setDescription(fakeStoreProductdto.getDescription());
        genericProductdto.setImage(fakeStoreProductdto.getImage());

        return genericProductdto;
    }
}
