//spring config in place of servlet-spring.xml
package com.training.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@ComponentScan("com.training.*")
@EnableWebMvc
public class MyConfiguration extends WebMvcConfigurerAdapter{ 

	public void  configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		  configurer.enable(); }

}
