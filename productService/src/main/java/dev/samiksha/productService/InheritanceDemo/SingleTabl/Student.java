package dev.samiksha.productService.InheritanceDemo.SingleTabl;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(
        name = "st_student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {
    private double psp;
    private double attendance;
}
