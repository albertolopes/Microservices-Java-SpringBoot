package com.allo.hroauth.entities;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User {

    private  Long id;

    private String name;

    private String email;

    private String password;

    private Set<Role> role = new HashSet<>();
}
