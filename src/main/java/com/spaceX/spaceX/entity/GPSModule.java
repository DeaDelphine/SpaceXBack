package com.spaceX.spaceX.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name="GPSMODULE")
@Data
@RequiredArgsConstructor
public class GPSModule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDGPSMODULE")
    private long id;
    @Column(name = "LATITUDE")
    private String latitude;
    @Column(name = "LONGITUDE")
    private String longitude;
    @Column(name = "ALTITUDE")
    private String altitude;

    @OneToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name="drone_id")
    private Drone drone;

    @JsonIgnore
    @OneToMany(mappedBy = "gpsModule")
    private List<FlightController> flightControllerList;

}
