package dev.samiksha.productService.InheritanceDemo.MappedSuperClass;

import jakarta.persistence.Entity;

@Entity(
        name = "msc_student")
public class Student extends User {
    private double psp;
    private double attendance;
}
