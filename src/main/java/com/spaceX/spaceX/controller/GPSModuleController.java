package com.spaceX.spaceX.controller;

import com.spaceX.spaceX.entity.GPSModule;
import com.spaceX.spaceX.entity.GPSModule;
import com.spaceX.spaceX.service.GPSModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class GPSModuleController {
    @Autowired
    GPSModuleService gpsModuleService;

    @PostMapping("/gpsModule")
    public GPSModule createGPSModule(@Validated @RequestBody(required = false) GPSModule gpsModule) {
        return gpsModuleService.saveGPSModule(gpsModule);
    }
    @GetMapping("/gpsModules/{idgpsModule}")
    public ResponseEntity getGPSModulebyId(@PathVariable(name= "idgpsModule") Long idgpsModule) {
        if(idgpsModule == null) {
            return ResponseEntity.badRequest().body("Canot retreive camion with null id");
        }
        GPSModule gpsModule1 = gpsModuleService.getGPSModuleByid(idgpsModule);
        if(gpsModule1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(gpsModule1);
    }

    @PutMapping("/gpsModules/{idGpsModule}")
    public ResponseEntity updatedGPSModuleById(@Validated @RequestBody GPSModule gpsModule, @PathVariable(name="idGpsModule") Long idGpsModule){
        GPSModule gpsModule1 = gpsModuleService.getGPSModuleByid(idGpsModule);

        if(idGpsModule == null) {
            return ResponseEntity.badRequest().body("Canot retreive camion with null id");
        }
        if(gpsModule.getLatitude() != null){
            gpsModule1.setLatitude(gpsModule.getLatitude());
        }
        if(gpsModule.getLongitude() != null) {
            gpsModule1.setLongitude(gpsModule.getLongitude());
        }
        if(gpsModule.getAltitude() != null) {
            gpsModule1.setAltitude(gpsModule.getAltitude());
        }
       

        gpsModuleService.updatedGPSModuleById(gpsModule1);
        return  ResponseEntity.ok().body(gpsModule1);
    }

    @DeleteMapping("/gpsModules/{idGpsModule}")
    public ResponseEntity<GPSModule> deleteModelGPSModule(@Validated @PathVariable(name= "idGpsModule") Long idGpsModule) {

        GPSModule gpsModule1 = gpsModuleService.getGPSModuleByid(idGpsModule);
        if(gpsModule1 == null) {
            return ResponseEntity.notFound().build();
        }
        gpsModuleService.deleteGPSModule(gpsModule1);
        return ResponseEntity.ok().body(gpsModule1);
    }
}
