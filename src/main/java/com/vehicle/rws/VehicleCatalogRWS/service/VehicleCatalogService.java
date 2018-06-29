package com.vehicle.rws.VehicleCatalogRWS.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.vehicle.rws.VehicleCatalogRWS.entity.Vehicle;

@Service
public interface VehicleCatalogService {
	

	List<Vehicle> getAllVehicles();
	
	ResponseEntity addVehicle(Vehicle v);
	
	String updateVehicle(Vehicle v);
	
	ResponseEntity<Object> deleteVehicle(String name);
	
	Vehicle getOneVehicles(String Name);
    
	List<Vehicle> getVehicleByType(String type);
}
