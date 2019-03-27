package com.techoffice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.techoffice.security.filter.JwtTokenAuthenticationFilter;
import com.techoffice.security.filter.JwtUsernamePasswordAuthenticationFilter;
import com.techoffice.security.web.JwtAuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class Config extends WebSecurityConfigurerAdapter {

	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> configurer = auth.inMemoryAuthentication();
		configurer.withUser("user").password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//		http.authorizeRequests().antMatchers("/").permitAll();
//
//		http.authorizeRequests().antMatchers("/auth").permitAll().and()
//			.addFilterBefore(new JwtUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		http.antMatcher("/").authorizeRequests().anyRequest().permitAll();
		
		http.antMatcher("/auth").exceptionHandling()
			.authenticationEntryPoint(unauthorizedHandler)
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().csrf().disable()
			.authorizeRequests().anyRequest().permitAll()
			.and().addFilterBefore(new JwtUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

		http.exceptionHandling()
			.authenticationEntryPoint(unauthorizedHandler)
			.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and().csrf().disable()
			.authorizeRequests().anyRequest().authenticated()
			.and().addFilterBefore(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

//		http.authorizeRequests().antMatchers("/**").permitAll().and()
//			.addFilterBefore(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

	}
}
