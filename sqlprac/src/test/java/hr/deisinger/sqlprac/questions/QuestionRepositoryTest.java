package hr.deisinger.sqlprac.questions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class QuestionRepositoryTest {

    @Autowired
    QuestionRepository questionRepository;

    @Test
    void findAll() {
        List<Question> questions = questionRepository.findAll();

        for (Question q : questions) {
            System.out.println(q.getTitle());
        }

        Assertions.assertNotNull(questions);
        Assertions.assertEquals(questions.size(), 3);
    }

    @Test
    void findFirstById() {
        Optional<Question> question = questionRepository.findFirstById(1);

        Assertions.assertNotNull(question);
        //Assertions.assertEquals(question.get().getId(), 1);
    }
}