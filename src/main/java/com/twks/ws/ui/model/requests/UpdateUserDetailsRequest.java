package com.twks.ws.ui.model.requests;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequest {
    @NotNull(message = "firstName cannot be null")
    @Size(min = 2, message = "firstName should be atleast 2 characters long")
    private String firstName;

    @NotNull(message = "lastName cannot be null")
    @Size(min = 2, message = "lastName should be atleast 2 characters long")
    private String lastName;

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
}
