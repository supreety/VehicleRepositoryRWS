package com.vehicle.rws.VehicleCatalogRWS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vehicle.rws.VehicleCatalogRWS.entity.Vehicle;
import com.vehicle.rws.VehicleCatalogRWS.service.VehicleCatalogService;

@RestController 
public class VehicleController {
	
	@Autowired
	VehicleCatalogService vehicleCatalog;
	
	@GetMapping(path="/vehicle")
	public List<Vehicle> getVehicles(){
		return  vehicleCatalog.getAllVehicles();
	}
	@GetMapping(path="/vehicle/{name}")
	public Vehicle getOneVehicles(@PathVariable String name){
		return  vehicleCatalog.getOneVehicles(name);
	}
	
	@GetMapping(path="/vehicle/type/{type}")
	public List<Vehicle> getVehiclesByType(@PathVariable("type") String vType){
		return  vehicleCatalog.getVehicleByType(vType);
	}
	
	@PostMapping(path="/vehicle")
	public ResponseEntity addVehicle(@RequestBody Vehicle v){
		return  vehicleCatalog.addVehicle(v);
	}

	@DeleteMapping(path="/vehicle/{name}")
	public ResponseEntity<Object> deleteVehicle(@PathVariable String name){
		return  vehicleCatalog.deleteVehicle(name);
	}
	@PutMapping(path="/vehicle")
	public String updateVehicle(@RequestBody Vehicle v){
		return  vehicleCatalog.updateVehicle(v);
	}

}
