package org.SchoolApp.Web.Dtos.Response;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;

    private long expiresIn;
}