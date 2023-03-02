package tdd;

public class User {
    private String login;
    private String password;
    private Status status;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public boolean verification(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }
}
