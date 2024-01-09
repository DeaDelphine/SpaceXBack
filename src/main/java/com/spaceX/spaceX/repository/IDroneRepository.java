package com.spaceX.spaceX.repository;

import com.spaceX.spaceX.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDroneRepository extends JpaRepository<Drone, Long> {
}
