package com.wehaul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.wehaul.converter.LocalDateTimeToStringConverter;
import com.wehaul.converter.LocalDateToStringConverter;
import com.wehaul.converter.StringToLoadTypeConverter;
import com.wehaul.converter.StringToLocalDateConverter;
import com.wehaul.converter.StringToLocalDateTimeConverter;
import com.wehaul.converter.StringToRoleConverter;
import com.wehaul.converter.StringToVehicleTypeConverter;

@Configuration
public class WebConfig implements WebMvcConfigurer  {

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

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/signin");
        //registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }
}