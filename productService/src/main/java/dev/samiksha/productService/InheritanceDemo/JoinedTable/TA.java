package dev.samiksha.productService.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(
        name = "jt_ta"
)
@PrimaryKeyJoinColumn(name = "id")
public class TA extends User {

    private double averageRating;
}
