package com.spaceX.spaceX.repository;


import com.spaceX.spaceX.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICameraRepository extends JpaRepository<Camera, Long> {
}
