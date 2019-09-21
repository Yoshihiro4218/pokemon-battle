package jp.co.pokemon.entity;

import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private String password;
    private String email;
    private boolean adminFlg;
}
