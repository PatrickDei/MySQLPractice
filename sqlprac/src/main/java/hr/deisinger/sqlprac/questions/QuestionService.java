package hr.deisinger.sqlprac.questions;

import java.util.List;
import java.util.Optional;

public interface QuestionService {
    List<QuestionDTO> findAll();

    Optional<QuestionDTO> findById(Integer id);
}
