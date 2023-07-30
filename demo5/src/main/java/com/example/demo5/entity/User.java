package com.example.demo5.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name="nguoi_dung")

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id ;

    @Column(name = "pass")
    private String pass ;

    @Column(name = "ten")
    private String ten ;

    @Column(name = "mail")
    private String mail;

    @Column(name = "quyen")
    private Boolean quyen ;

    @

}
