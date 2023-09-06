package dev.samiksha.productService.dtos;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class GenericProductdto {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
