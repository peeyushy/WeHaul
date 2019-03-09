package com.wehaul.converter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;

public class LocalDateTimeToStringConverter implements Converter<LocalDateTime,String> {	
	@Override
	public String convert(LocalDateTime source) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		return source.format(formatter);
	}
}