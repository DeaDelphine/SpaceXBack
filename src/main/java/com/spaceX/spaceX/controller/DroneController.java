package com.spaceX.spaceX.controller;

import com.spaceX.spaceX.entity.Drone;
import com.spaceX.spaceX.entity.Drone;
import com.spaceX.spaceX.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@CrossOrigin("*")
public class DroneController {

    @Autowired
    DroneService droneService;

    @PostMapping("/drone")
    public Drone createDrone(@Validated @RequestBody(required = false) Drone drone) {
        return droneService.saveDrone(drone);
    }
    @GetMapping("/drones/{iddrone}")
    public ResponseEntity getDronebyId(@PathVariable(name= "iddrone") Long iddrone) {
        if(iddrone == null) {
            return ResponseEntity.badRequest().body("Canot retreive camion with null id");
        }
        Drone drone1 = droneService.getDroneByid(iddrone);
        if(drone1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(drone1);
    }

    @GetMapping("/drones")
    public List<Drone> getAllDrones() {
        return droneService.getAllDrones();
    }

    @PutMapping("/drones/{idDrone}")
    public ResponseEntity updatedDroneById(@Validated @RequestBody Drone drone, @PathVariable(name="idDrone") Long idDrone){
        Drone drone1 = droneService.getDroneByid(idDrone);

        if(idDrone == null) {
            return ResponseEntity.badRequest().body("Canot retreive camion with null id");
        }
        if(drone.getCapaciteMaxBat() != null){
            drone1.setCapaciteMaxBat(drone.getCapaciteMaxBat());
        }
        if(drone.getPoids() != 0){
            drone1.setPoids(drone.getPoids());
        }
        if(drone.getPorteeMax() != null) {
            drone1.setPorteeMax(drone.getPorteeMax());
        }
        if (drone.getModele() != null){
            drone1.setModele(drone.getModele());
        }

        droneService.updatedDroneById(drone1);
        return  ResponseEntity.ok().body(drone1);
    }

    @DeleteMapping("/drones/{iddrone}")
    public ResponseEntity<Drone> deleteModelDrone(@Validated @PathVariable(name= "iddrone") Long iddrone) {

        Drone drone1 = droneService.getDroneByid(iddrone);
        if(drone1 == null) {
            return ResponseEntity.notFound().build();
        }
        droneService.deleteDrone(drone1);
        return ResponseEntity.ok().body(drone1);
    }
}
