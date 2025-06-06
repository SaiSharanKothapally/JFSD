package firstspring.springboot_app;

 import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class User {
    @NotNull(message = "Name cannot be null")
    private String name;
    @Email(message = "Email cannot be null")
    private String email;
    private int id;
    private static int idCounter = 0;

    public User() {
        this.id=idCounter++;
    }

    public User(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

}
