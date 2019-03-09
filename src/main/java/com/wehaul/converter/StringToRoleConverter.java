package com.wehaul.converter;

import org.springframework.core.convert.converter.Converter;

import com.wehaul.model.Role;

public class StringToRoleConverter implements Converter<String, Role> {

	@Override
	public Role convert(String id) {
		return new Role(Long.parseLong(id));
	}
}