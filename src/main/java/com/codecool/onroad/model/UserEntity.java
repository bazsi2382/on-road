package com.codecool.onroad.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String email;
    private String userName;
    private String firstName;
    private String lastName;
    private String password;

    @Singular("passenger")
    @OneToMany(mappedBy = "passenger", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Road> roadPassenger;

    @Singular("transporter")
    @OneToMany(mappedBy = "transporter", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Road> roadTransporter;

}
