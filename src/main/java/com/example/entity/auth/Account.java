package com.example.entity.auth;

import lombok.Data;

/**
 * @author wzt
 */
@Data
public class Account {
    int id;
    String email;
    String username;
    String password;
    String avatar;
}
