package com.twks.ws.ui.model.requests;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequest {
    @NotNull(message = "firstName cannot be null")
    @Size(min = 2, message = "firstName should be atleast 2 characters long")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    @Size(min = 2, message = "lastName should be atleast 2 characters long")
    private String lastName;

    @NotNull(message = "email cannot be null")
    @Email(message = "Enter the valid Email address")
    private String email;

    @NotNull(message = "password cannot be null")
    @Size(min = 8, max = 16, message = "passwoed length should be in between 8 and 16 characters")
    private String password;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
