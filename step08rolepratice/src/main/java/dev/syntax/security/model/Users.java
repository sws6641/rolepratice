package dev.syntax.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@ToString
@Getter
@Table(name = "user")
public class Users {
    @Id
    private int userId;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    private String userPw;
    private String userName;

}
