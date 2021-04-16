package ru.veqveq.server.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users_tbl")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fld")
    private Long id;

    @Column(name = "username_fld")
    private String nickname;

    @Column(name = "login_fld")
    private String username;

    @Column(name = "password_fld")
    private String password;
}
