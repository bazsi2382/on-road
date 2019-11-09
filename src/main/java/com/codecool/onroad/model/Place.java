package com.codecool.onroad.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Place {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String longitude;
    private String latitude;

    @Singular("start")
    @OneToMany(mappedBy = "start", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Road> roadStart;

    @Singular("destination")
    @OneToMany(mappedBy = "destination", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
    private Set<Road> roadDestination;
}
