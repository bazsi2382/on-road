package com.codecool.onroad.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Road {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private UserEntity transporter;

    @ManyToOne
    private UserEntity passenger;

    @ManyToOne
    private Place start;

    @ManyToOne
    private Place destination;

    private Long price;
    private LocalDateTime startTime;
    private LocalDateTime plannedArrival;

}
