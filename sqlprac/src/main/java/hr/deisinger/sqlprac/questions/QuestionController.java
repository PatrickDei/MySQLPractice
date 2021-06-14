package hr.deisinger.sqlprac.questions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<QuestionDTO>> getAll(){
        List<QuestionDTO> questions =  questionService.findAll();
        if(questions.isEmpty())
            return ResponseEntity
                    .status(HttpStatus.NO_CONTENT)
                    .build();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(questions);
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<QuestionDTO> getById(@PathVariable Integer questionId){
        return questionService.findById(questionId)
                .map( q ->
                        ResponseEntity.status(HttpStatus.OK)
                        .body(q)
                )
                .orElseGet( () ->
                        ResponseEntity.status(HttpStatus.NO_CONTENT)
                        .build()
                );
    }
}
