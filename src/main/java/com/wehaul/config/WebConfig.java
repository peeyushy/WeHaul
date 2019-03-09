package com.erwebadmin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.erwebadmin.converter.LocalDateTimeToStringConverter;
import com.erwebadmin.converter.LocalDateToStringConverter;
import com.erwebadmin.converter.StringToLoadTypeConverter;
import com.erwebadmin.converter.StringToLocalDateConverter;
import com.erwebadmin.converter.StringToLocalDateTimeConverter;
import com.erwebadmin.converter.StringToRoleConverter;
import com.erwebadmin.converter.StringToVehicleTypeConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(new StringToRoleConverter());
		registry.addConverter(new StringToLoadTypeConverter());
		registry.addConverter(new StringToVehicleTypeConverter());
		registry.addConverter(new StringToLocalDateTimeConverter());
		registry.addConverter(new LocalDateTimeToStringConverter());
		registry.addConverter(new LocalDateToStringConverter());
		registry.addConverter(new StringToLocalDateConverter());
	}
}