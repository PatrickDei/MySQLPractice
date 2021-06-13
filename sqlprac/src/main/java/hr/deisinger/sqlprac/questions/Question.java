package hr.deisinger.sqlprac.questions;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Question")
public class Question {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "task")
    private String task;

    @Column(name = "answers")
    private String answers;

    public Question(){}

    public Question(Integer id, String title, String description, String task, String answers) {
        this.id = id;
        this.title = title;
        this.task = task;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object other){
        if (this == other) return true;
        if(!(other instanceof Question)) return false;

        Question question = (Question) other;
        return this.id == question.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id, title, description, task, answers);
    }
}
