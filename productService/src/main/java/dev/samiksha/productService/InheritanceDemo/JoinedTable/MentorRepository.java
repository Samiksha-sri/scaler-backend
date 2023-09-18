package dev.samiksha.productService.InheritanceDemo.JoinedTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("jt_mentor_repository")
public interface MentorRepository extends JpaRepository<Mentor, Long> {
}
