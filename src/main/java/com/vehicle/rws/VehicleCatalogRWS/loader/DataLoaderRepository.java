package com.vehicle.rws.VehicleCatalogRWS.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.vehicle.rws.VehicleCatalogRWS.entity.Vehicle;
import com.vehicle.rws.VehicleCatalogRWS.entity.VehicleRepository;

@Component
public class DataLoaderRepository implements CommandLineRunner {

	private static final Logger log=LoggerFactory.getLogger(DataLoaderRepository.class);
	
	@Autowired
	private VehicleRepository vr;
	
	@Override
	public void run(String... args) throws Exception {
		
		vr.save(new Vehicle("car","RAV4","Toyota"));
		vr.save(new Vehicle("truck","Raptor","Ford"));
		vr.save(new Vehicle("SUV","4Runner","Toyota"));
		vr.save(new Vehicle("car","Accord","Honda"));
		log.info("New Vehicles added");
		
	}

}
