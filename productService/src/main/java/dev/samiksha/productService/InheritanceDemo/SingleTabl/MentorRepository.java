package dev.samiksha.productService.InheritanceDemo.SingleTabl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("st_mentor_repository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
