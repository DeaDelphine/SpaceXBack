package com.spaceX.spaceX.service;

import com.spaceX.spaceX.entity.FlightController;
import com.spaceX.spaceX.entity.FlightController;
import com.spaceX.spaceX.repository.IFlightControllerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightControllerService {
    @Autowired
    IFlightControllerRepository flightControllerRepository;

    //Save
    public FlightController saveFlightController(FlightController flightController) {
        return flightControllerRepository.save(flightController);
    }
    //get a FlightController
    public FlightController getFlightControllerByid(Long idFlightCont) {
        return flightControllerRepository.findById(idFlightCont).get();
    }
    //put a FlightController
    public FlightController updateFlightControllerById(FlightController flightController){
        return flightControllerRepository.save(flightController);
    }

    //delete a FlightController
    public void deleteFlightController(FlightController flightController){
        flightControllerRepository.delete(flightController);
    }
}
