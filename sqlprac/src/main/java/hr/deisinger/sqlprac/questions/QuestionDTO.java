package hr.deisinger.sqlprac.questions;

import java.util.List;

public class QuestionDTO {
    private Integer id;

    private String title;

    private String text;

    private List<String> answers;

    public QuestionDTO(Integer id, String title, String text, List<String> answers) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.answers = answers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
