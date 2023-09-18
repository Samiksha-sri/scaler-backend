package dev.samiksha.productService.InheritanceDemo.TablePerClass;

import jakarta.persistence.Entity;

@Entity(
        name = "tpc_ta"
)
public class TA extends User{

    private double averageRating;
}
