package com.erwebadmin.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {

	@Override
	public LocalDate convert(String source) {
		if (source.isEmpty()) {
			return null;
		} else {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date parsedDate = null;
			try {
				parsedDate = dateFormat.parse(source);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}
	}
}