package com.wehaul.converter;

import org.springframework.core.convert.converter.Converter;

import com.wehaul.model.LoadType;

public class StringToLoadTypeConverter implements Converter<String, LoadType> {

	@Override
	public LoadType convert(String id) {
		return new LoadType(Long.parseLong(id));
	}
}