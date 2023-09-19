package dev.samiksha.productService.dtos;

import dev.samiksha.productService.models.Category;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Getter
@Setter
public class GenericProductdto {
    private UUID id;
    private String title;
    private double price;
    private Category category;
    private String description;
    private String image;
}
