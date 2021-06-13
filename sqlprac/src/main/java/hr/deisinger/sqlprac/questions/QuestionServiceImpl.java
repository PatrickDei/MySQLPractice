package hr.deisinger.sqlprac.questions;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService{

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    private QuestionDTO QuestionToDTO(Question question){
        return new QuestionDTO(
                question.getId(),
                question.getTitle(),
                question.getTask(),
                Arrays.stream(question.getAnswers().split(",")).collect(Collectors.toList())
        );
    }

    @Override
    public List<QuestionDTO> findAll() {
    return questionRepository.findAll().stream().map(this::QuestionToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<QuestionDTO> findById(Integer id) {
        return questionRepository.findFirstById(id).map(this::QuestionToDTO);
    }
}
