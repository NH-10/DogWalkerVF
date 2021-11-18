package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pe.edu.upc.spring.serviceimpl.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.print("Hola******");

		http.authorizeRequests()
				.antMatchers("/", "/css/**", "/js/**", "/img/**").permitAll()
				.and().formLogin().loginPage("/login").permitAll()
				.and().logout().permitAll().and()
				.exceptionHandling().accessDeniedPage("/error");
		/*
		http.authorizeRequests()
		.antMatchers("/", "/css/**", "/js/**", "/img/**","/owner/irRegistrar","/login").permitAll()
		.antMatchers("/owner/**").access("hasRole('ROLE_ADMIN')")	
		.antMatchers("/walker/**").access("hasRole('ROLE_PASEADOR')")
		.antMatchers("/login/**").access("hasRole('ROLE_DUENO') or hasRole('ROLE_PASEADOR')")
		.and().logout().permitAll().and()
		.exceptionHandling().accessDeniedPage("/error");*/
	
	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
		System.out.print("configurerGlobal******");

		build.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

	}
}
