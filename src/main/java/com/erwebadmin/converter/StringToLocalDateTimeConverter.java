package com.erwebadmin.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateTimeConverter implements Converter<String, LocalDateTime> {

	@Override
	public LocalDateTime convert(String source) {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		java.util.Date parsedDate = null;
		try {
			parsedDate = dateFormat.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return parsedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
}