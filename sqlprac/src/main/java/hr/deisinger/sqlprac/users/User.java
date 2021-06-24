package hr.deisinger.sqlprac.users;


import hr.deisinger.sqlprac.authority.Authority;
import hr.deisinger.sqlprac.questions.Question;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "User")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "User_Question",
            joinColumns = @JoinColumn(name = "User_Id"),
            inverseJoinColumns = @JoinColumn(name = "Question_Id")
    )
    private Set<Question> questionsCompleted;

    @ManyToMany
    @JoinTable(
            name = "User_Authority",
            joinColumns = @JoinColumn(name = "User_Id"),
            inverseJoinColumns = @JoinColumn(name = "Authority_Id"))
    private Set<Authority> authorities;

    public User(){}

    public User(Integer id, String username, String password, String firstName, String lastName, Set<Question> questionsCompleted, Set<Authority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.questionsCompleted = questionsCompleted;
        this.authorities = authorities;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Set<Question> getQuestionsCompleted() {
        return questionsCompleted;
    }

    public void setQuestionsCompleted(Set<Question> questionsCompleted) {
        this.questionsCompleted = questionsCompleted;
    }
}