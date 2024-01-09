package com.spaceX.spaceX.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="FLIGHTCONTROLLER")
@Data
@RequiredArgsConstructor
public class FlightController {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDFLIGHTCONTROLLER")
    private long id;
    @Column(name = "VITESSE")
    private String vitesse;
    @Column(name = "ALTITUDECIBLE")
    private String altitudeCible;
    @Column(name = "POSITIONCIBLE")
    private String positionCible;


    @ManyToOne
    @JoinColumn(name="gpsModule_id")
    private GPSModule gpsModule;

}
