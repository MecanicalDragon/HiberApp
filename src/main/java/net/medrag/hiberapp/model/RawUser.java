package net.medrag.hiberapp.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "raw_users")
public class RawUser {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Column(name = "email")
    private String email;

    @Column(name = "confirm_code")
    private String confirmCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmCode() {
        return confirmCode;
    }

    public void setConfirmCode(String confirmCode) {
        this.confirmCode = confirmCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RawUser rawUser = (RawUser) o;
        return Objects.equals(id, rawUser.id) &&
                Objects.equals(username, rawUser.username) &&
                Objects.equals(password, rawUser.password) &&
                Objects.equals(confirmPassword, rawUser.confirmPassword) &&
                Objects.equals(email, rawUser.email) &&
                Objects.equals(confirmCode, rawUser.confirmCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, confirmPassword, email, confirmCode);
    }

    @Override
    public String toString() {
        return "RawUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                ", email='" + email + '\'' +
                ", confirmCode='" + confirmCode + '\'' +
                '}';
    }
}
