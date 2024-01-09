package com.spaceX.spaceX.service;

import com.spaceX.spaceX.entity.Drone;
import com.spaceX.spaceX.entity.Drone;
import com.spaceX.spaceX.repository.IDroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService {

    @Autowired
    IDroneRepository droneRepository;

    //Save
    public Drone saveDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    //get a Drone
    public Drone getDroneByid(Long idDron) {
        return droneRepository.findById(idDron).get();
    }
    public List<Drone> getAllDrones(){
        return droneRepository.findAll();
    }
    //put a Drone
    public Drone updatedDroneById(Drone drone){
        return droneRepository.save(drone);
    }

    //delete a Drone
    public void deleteDrone(Drone drone){
        droneRepository.delete(drone);
    }
}
