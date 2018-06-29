package com.vehicle.rws.VehicleCatalogRWS.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.vehicle.rws.VehicleCatalogRWS.entity.Vehicle;
import com.vehicle.rws.VehicleCatalogRWS.entity.VehicleRepository;


@Repository
@Transactional
public class VehicleCatalogServiceImpl implements VehicleCatalogService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private VehicleRepository vr;
	private static List vehicleList=new ArrayList<Vehicle>();
	
	@Override
	public List<Vehicle> getAllVehicles() {
				return vr.findAll();
	}
	
	public ResponseEntity<Object> addVehicle(Vehicle v) {		
		vr.save(v);
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{name}").buildAndExpand(v.getName()).toUri();
		return ResponseEntity.created(location).build();
	}

	@Override
	public ResponseEntity<Object> deleteVehicle(String name) {
		String result;
		if(vr.existsById(name)) {
			vr.deleteById(name);
			result="Successfully Deleted from Vehicle List ";
			return ResponseEntity.ok().build();
		}
		else {
			result="Vehicle not present!!";
			return ResponseEntity.notFound().build();
		}
				 
	}

	@Override
	public String updateVehicle(Vehicle v) {
		vr.save(v);
		return "success";
	}

	@Override
	public Vehicle getOneVehicles(String name) {
		Optional<Vehicle> ov=vr.findById(name);
		return ov.get();
		
	}

	@Override
	public List<Vehicle> getVehicleByType(String vType) {
		List<Vehicle> v=vr.findAll();
		List vByType=new ArrayList<Vehicle>();
		for (Vehicle vtemp:v) {
			if(vtemp.getType().equals(vType)) {
				vByType.add(vtemp);
			}
		}
		
		return vByType;
	}
	
	
	
	
	
}