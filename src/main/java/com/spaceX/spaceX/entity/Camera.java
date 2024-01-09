package com.spaceX.spaceX.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@Table(name="CAMERA")
@Data
@RequiredArgsConstructor
public class Camera {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDCAMERA")
    private long id;
    @Column(name = "RESOLUTION")
    private String resolution;
    @Column(name = "ZOOM")
    private String zoom;

    @JsonIgnore
    @OneToMany(mappedBy = "camera")
    private List<Drone> droneList;
}
