package hr.deisinger.sqlprac.questions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/question")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionDTO>> findAll(){
        List<QuestionDTO> questions =  questionService.findAll();
        if(questions.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(questions);
    }
}
