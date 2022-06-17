package com.idat.Examen2.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailService service;
	
	@Autowired
	private TokenFilter filter;
	
	@Autowired
	private EntryPoint entrypoint;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {		
		auth.userDetailsService(service).passwordEncoder(encriptado());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		
		
		http.authorizeRequests().antMatchers("/crearToken").permitAll().antMatchers("/producto/v1/listar").hasAnyAuthority("ROLE_USER","ROLE_ADMIN").antMatchers("/producto/v1/*").hasRole("ADMIN")
		.antMatchers("/bodega/v1/listar").hasAnyAuthority("ROLE_USER","ROLE_ADMIN").antMatchers("/bodega/v1/*").hasRole("ADMIN")
		.antMatchers("/cliente/v1/listar").hasAnyAuthority("ROLE_USER","ROLE_ADMIN").antMatchers("/cliente/v1/*").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().exceptionHandling().authenticationEntryPoint(entrypoint)
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)		
		.and().addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)		
		.csrf().disable();
		
				
	}
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}

	@Bean
	public PasswordEncoder encriptado() {
		return new BCryptPasswordEncoder();
	}
	
	

}