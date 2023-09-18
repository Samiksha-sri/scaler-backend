package dev.samiksha.productService.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(
        name = "msc_ta"
)
public class TA extends User {

    private double averageRating;
}
