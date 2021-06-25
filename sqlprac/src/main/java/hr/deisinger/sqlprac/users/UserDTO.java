package hr.deisinger.sqlprac.users;


import java.util.Set;

public class UserDTO {
    private long id;
    private String username;
    private String firstName;
    private String lastName;
    private Set<String> authorities;
    private Set<Integer> completedQuestions;

    public UserDTO(long id, String username, String firstName, String lastName, Set<String> authorities, Set<Integer> completedQuestions) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.authorities = authorities;
        this.completedQuestions = completedQuestions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Set<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<String> authorities) {
        this.authorities = authorities;
    }

    public Set<Integer> getQuestions() {
        return completedQuestions;
    }

    public void setQuestions(Set<Integer> completedQuestions) {
        this.completedQuestions = completedQuestions;
    }
}
