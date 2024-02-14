package dev.syntax.security.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@ToString
public class Authority {
    @Id
    private int authId;
    private int roleId;
    private String authName;
}
