package com.erwebadmin.converter;

import org.springframework.core.convert.converter.Converter;

import com.erwebadmin.model.VehicleType;

public class StringToVehicleTypeConverter implements Converter<String, VehicleType> {

	@Override
	public VehicleType convert(String id) {
		return new VehicleType(Long.parseLong(id));
	}
}