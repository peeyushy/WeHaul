package com.erwebadmin.converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public class LocalDateToStringConverter implements Converter<LocalDate,String> {	
	@Override
	public String convert(LocalDate source) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return source.format(formatter);
	}
}