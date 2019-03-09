package com.wehaul.converter;

import org.springframework.core.convert.converter.Converter;

import com.wehaul.model.VehicleType;

public class StringToVehicleTypeConverter implements Converter<String, VehicleType> {

	@Override
	public VehicleType convert(String id) {
		if(id.equalsIgnoreCase("select")) {
			return new VehicleType();
		}else {
			return new VehicleType(Long.parseLong(id));	
		}
		
	}
}