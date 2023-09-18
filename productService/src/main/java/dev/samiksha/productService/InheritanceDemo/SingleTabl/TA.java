package dev.samiksha.productService.InheritanceDemo.SingleTabl;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(
        name = "st_ta"
)
@PrimaryKeyJoinColumn(name = "id")
public class TA extends User {

    private double averageRating;
}
