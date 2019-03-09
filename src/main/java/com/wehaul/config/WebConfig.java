package com.wehaul.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.wehaul.converter.LocalDateTimeToStringConverter;
import com.wehaul.converter.LocalDateToStringConverter;
import com.wehaul.converter.StringToLoadTypeConverter;
import com.wehaul.converter.StringToLocalDateConverter;
import com.wehaul.converter.StringToLocalDateTimeConverter;
import com.wehaul.converter.StringToRoleConverter;
import com.wehaul.converter.StringToVehicleTypeConverter;

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