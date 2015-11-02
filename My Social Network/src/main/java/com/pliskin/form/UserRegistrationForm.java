package com.pliskin.form;

/**
 * Created by aleksandrpliskin on 29.10.15.
 */

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

public class UserRegistrationForm {

    @NotEmpty(message = "Логин не может быть пустым")
    private String username;

    @Size(min = 6, max = 24, message = "Пароль неверной длины")
    private String password;

    @Size(min = 6, max = 24, message = "Пароль неверной длины")
    private String repassword;

    @Email(regexp = ".+@.+")
    @NotEmpty(message = "Невалидный email")
    private String email;

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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
