package hr.deisinger.sqlprac.questions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query(value = "select * from Question", nativeQuery = true)
    List<Question> findAll();

    Optional<Question> findFirstById (Integer id);
}
