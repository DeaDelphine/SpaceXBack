package com.spaceX.spaceX.service;

import com.spaceX.spaceX.entity.Camera;
import com.spaceX.spaceX.entity.Camera;
import com.spaceX.spaceX.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CameraService {
    @Autowired
    ICameraRepository cameraRepository;

    //Save
    public Camera saveCamera(Camera camera) {
        return cameraRepository.save(camera);
    }
    //get a Camera
    public Camera getCameraByid(Long idCam) {
        return cameraRepository.findById(idCam).get();
    }
    //put a Camera
    public Camera updatedCameraById(Camera camera){
        return cameraRepository.save(camera);
    }

    //delete a Camera
    public void deleteCamera(Camera camera){
        cameraRepository.delete(camera);
    }
}
