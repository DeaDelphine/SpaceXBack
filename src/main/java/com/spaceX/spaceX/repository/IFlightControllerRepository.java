package com.spaceX.spaceX.repository;


import com.spaceX.spaceX.entity.FlightController;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlightControllerRepository extends JpaRepository<FlightController, Long> {
}
