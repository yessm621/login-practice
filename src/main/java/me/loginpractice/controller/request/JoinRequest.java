package me.loginpractice.controller.request;

import lombok.Data;

@Data
public class JoinRequest {

    private String email;
    private String password;
}
