package com.spaceX.spaceX.service;

import com.spaceX.spaceX.entity.GPSModule;
import com.spaceX.spaceX.repository.IGPSModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GPSModuleService {
    @Autowired
    IGPSModuleRepository gpsModuleRepository;

    //Save
    public GPSModule saveGPSModule(GPSModule gpsModule) {
        return gpsModuleRepository.save(gpsModule);
    }

    //get a GPSModule
    public GPSModule getGPSModuleByid(Long idGpsMod) {
        return gpsModuleRepository.findById(idGpsMod).get();
    }
    //put a GPSModule
    public GPSModule updatedGPSModuleById(GPSModule gpsModule){
        return gpsModuleRepository.save(gpsModule);
    }

    //delete a GPSModule
    public void deleteGPSModule(GPSModule gpsModule){
        gpsModuleRepository.delete(gpsModule);
    }
}
