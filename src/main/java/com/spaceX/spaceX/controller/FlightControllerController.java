package com.spaceX.spaceX.controller;

import com.spaceX.spaceX.entity.FlightController;
import com.spaceX.spaceX.entity.FlightController;
import com.spaceX.spaceX.service.FlightControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class FlightControllerController {
    @Autowired
    FlightControllerService flightControllerService;

    @PostMapping("/flightController")
    public FlightController createFlightController(@Validated @RequestBody(required = false) FlightController flightController) {
        return flightControllerService.saveFlightController(flightController);
    }
    @GetMapping("/flightControllers/{idflightController}")
    public ResponseEntity getFlightControllerbyId(@PathVariable(name= "idflightController") Long idflightController) {
        if(idflightController == null) {
            return ResponseEntity.badRequest().body("Canot retreive camion with null id");
        }
        FlightController flightController1 = flightControllerService.getFlightControllerByid(idflightController);
        if(flightController1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(flightController1);
    }

    @PutMapping("/flightControllers/{idFlightController}")
    public ResponseEntity updatedFlightControllerById(@Validated @RequestBody FlightController flightController, @PathVariable(name="idFlightController") Long idFlightController){
        FlightController flightController1 = flightControllerService.getFlightControllerByid(idFlightController);

        if(idFlightController == null) {
            return ResponseEntity.badRequest().body("Canot retreive camion with null id");
        }
        if(flightController.getVitesse() != null){
            flightController1.setVitesse(flightController.getVitesse() );
        }
        if(flightController.getAltitudeCible() != null){
            flightController1.setAltitudeCible(flightController.getAltitudeCible());
        }
        if(flightController.getPositionCible()!= null) {
            flightController1.setPositionCible(flightController.getPositionCible());
        }

        flightControllerService.updateFlightControllerById(flightController1);
        return  ResponseEntity.ok().body(flightController1);
    }

    @DeleteMapping("/flightControllers/{idflightController}")
    public ResponseEntity<FlightController> deleteModelFlightController(@Validated @PathVariable(name= "idflightController") Long idflightController) {

        FlightController flightController1 = flightControllerService.getFlightControllerByid(idflightController);
        if(flightController1 == null) {
            return ResponseEntity.notFound().build();
        }
        flightControllerService.deleteFlightController(flightController1);
        return ResponseEntity.ok().body(flightController1);
    }
}
