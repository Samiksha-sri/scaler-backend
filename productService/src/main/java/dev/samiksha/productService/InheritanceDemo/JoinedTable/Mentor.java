package dev.samiksha.productService.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(
        name = "jt_mentor")
@PrimaryKeyJoinColumn(name = "id")
public class Mentor extends User {

    private double averageRating;
}
