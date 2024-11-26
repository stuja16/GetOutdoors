package edu.lawrence.getoutdoors.security;

// Spring-level includes [Class Annotations]
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

// Spring-level includes [Field Annotations]
import org.springframework.beans.factory.annotation.Autowired;

// Spring-level includes [Function Annotations]
import org.springframework.context.annotation.Bean;

// Spring-level includes [Enums]
import org.springframework.http.HttpMethod;
import org.springframework.security.config.http.SessionCreationPolicy;

// Spring-level includes [Security Helpers]
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	JwtAuthFilter jwtAuthFilter;

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(
						authorize -> authorize
								.requestMatchers(HttpMethod.POST, "/users", "/users/login").permitAll()
								.requestMatchers(HttpMethod.GET, "[get request urls]").permitAll()
								.requestMatchers("/swagger-ui/**", "/swagger-resources/*", "/v3/api-docs/**")
								.permitAll().anyRequest().authenticated())
				.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}

}
