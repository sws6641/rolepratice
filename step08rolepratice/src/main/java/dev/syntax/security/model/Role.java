package dev.syntax.security.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@ToString
@Getter
public class Role {
    @Id
    private int roleId;
    private String roleName;
}
