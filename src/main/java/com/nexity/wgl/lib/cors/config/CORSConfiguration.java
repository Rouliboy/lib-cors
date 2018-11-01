package com.nexity.wgl.lib.cors.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfiguration {

	@Bean
	@Profile("!prod")
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(final CorsRegistry registry) {

				// log.info("Ajout du CORS *");

				// @formatter:off
				registry.addMapping("/**")
					.allowedHeaders("*")
					.allowedMethods("*")
					.allowedOrigins("*")
					.exposedHeaders("Authorization");
				// @formatter:on
			}
		};
	}
}
