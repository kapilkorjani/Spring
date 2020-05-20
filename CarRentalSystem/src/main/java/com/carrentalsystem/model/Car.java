package com.carrentalsystem.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Car {

	@Id @GeneratedValue
	private int cId;
	private String cName;
	@Enumerated(EnumType.STRING)
	private CarType type;
	private int chargePerKm;
	@Enumerated(EnumType.STRING)
	private CarStatus status;
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public CarType getType() {
		return type;
	}
	public void setType(CarType type) {
		this.type = type;
	}
	public int getChargePerKm() {
		return chargePerKm;
	}
	public void setChargePerKm(int chargePerKm) {
		this.chargePerKm = chargePerKm;
	}
	public CarStatus getStatus() {
		return status;
	}
	public void setStatus(CarStatus status) {
		this.status = status;
	}
	
}
