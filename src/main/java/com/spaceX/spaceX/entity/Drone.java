package com.spaceX.spaceX.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="DRONE")
@Data
@RequiredArgsConstructor
public class Drone {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDDRONE")
    private long id;

    @Column(name = "MODEL")
    private String modele;
    @Column(name = "POIDS")
    private Double poids;
    @Column(name = "PORTEEMAX")
    private String porteeMax;
    @Column(name = "CAPACITEMAXBAT")
    private String capaciteMaxBat;


    @ManyToOne
    @JoinColumn(name="camera_id")
    private Camera camera;

}
