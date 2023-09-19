package dev.samiksha.productService.productServiceClients;

import dev.samiksha.productService.models.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
public class FakeStoreProductdto {

    private UUID id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;
}
