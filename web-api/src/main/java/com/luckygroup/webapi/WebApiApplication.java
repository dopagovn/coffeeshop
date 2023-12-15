package com.luckygroup.webapi;

import com.luckygroup.webapi.utils.JwtUtils;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class WebApiApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebApiApplication.class, args);
    JwtUtils jwtUtils = new JwtUtils();

    System.out.println(jwtUtils.generatorToken("dopagovn@gmail.com"));
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry
          .addMapping("/**")
          .allowedOrigins("http://localhost:3000")
          .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
          .allowedHeaders("Content-Type")
          .allowCredentials(true)
          .maxAge(3600);
      }
    };
  }

  @Configuration
  public class ApplicationConfig {

    @Bean
    public ModelMapper modelMapper() {
      ModelMapper modelMapper = new ModelMapper();
      return modelMapper;
    }
  }
}
