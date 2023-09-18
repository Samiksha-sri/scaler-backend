package dev.samiksha.productService.InheritanceDemo.JoinedTable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(
        name = "jt_student")
@PrimaryKeyJoinColumn(name = "id")
public class Student extends User {
    private double psp;
    private double attendance;
}
