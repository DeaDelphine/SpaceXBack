package com.spaceX.spaceX.controller;

import com.spaceX.spaceX.entity.Camera;
import com.spaceX.spaceX.service.CameraService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin("*")
public class CameraController {
    @Autowired
    CameraService cameraService;

    @PostMapping("/camera")
    public Camera createCamera(@Validated @RequestBody(required = false) Camera camera) {
        return cameraService.saveCamera(camera);
    }

    @GetMapping("/cameras/{idcamera}")
    public ResponseEntity getCamerabyId(@PathVariable(name= "idcamera") Long idcamera) {
        if(idcamera == null) {
            return ResponseEntity.badRequest().body("Canot retreive camion with null id");
        }
        Camera camera1 = cameraService.getCameraByid(idcamera);
        if(camera1 == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(camera1);
    }
    @PutMapping("/cameras/{idCamera}")
    public ResponseEntity updatedCameraById(@Validated @RequestBody Camera camera, @PathVariable(name="idCamera") Long idCamera){
        if(idCamera == null) {
            return ResponseEntity.badRequest().body("Canot retreive camion with null id");
        }
        Camera camera1 = cameraService.getCameraByid(idCamera);

        if(camera.getZoom() != null){
            camera1.setZoom(camera.getZoom());
        }
        if(camera.getResolution() != null){
            camera1.setResolution(camera.getResolution());
        }

        cameraService.updatedCameraById(camera1);
        return  ResponseEntity.ok().body(camera1);
    }

    @DeleteMapping("/cameras/{idcamera}")
    public ResponseEntity<Camera> deleteModelCamera(@Validated @PathVariable(name= "idcamera") Long idcamera) {

        Camera camera1 = cameraService.getCameraByid(idcamera);
        if(camera1 == null) {
            return ResponseEntity.notFound().build();
        }
        cameraService.deleteCamera(camera1);
        return ResponseEntity.ok().body(camera1);
    }
}
