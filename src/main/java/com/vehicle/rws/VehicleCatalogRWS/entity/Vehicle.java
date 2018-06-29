package com.vehicle.rws.VehicleCatalogRWS.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.transaction.Transactional;

@Entity

public class Vehicle {
private String type;
@Id
private String name;
String brand;

public  Vehicle() {}

public Vehicle(String type, String name, String brand) {
	super();
	this.type = type;
	this.name = name;
	this.brand = brand;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getBrand() {
	return brand;
}

public void setBrand(String brand) {
	this.brand = brand;
}

@Override
public String toString() {
	return "Vehicle [type=" + type + ", name=" + name + ", brand=" + brand + "]";
}



}
