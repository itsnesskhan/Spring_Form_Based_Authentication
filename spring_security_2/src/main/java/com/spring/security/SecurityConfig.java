package com.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.spring.handler.CustomAccessDeniedHandler;

@EnableWebSecurity
public class SecurityConfig {
	
		@Autowired
		private CustomAccessDeniedHandler customAccessDeniedHandler;
	
		@Bean
		public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
			http.
			csrf().disable()
			.authorizeRequests()
			.antMatchers("index","/css/**","/js/**").permitAll()
			.antMatchers(HttpMethod.DELETE,"/api/students/**").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.POST,"/api/students/**").permitAll()
			.antMatchers(HttpMethod.PUT,"/api/students/**").hasAuthority("ADMIN")
			.antMatchers(HttpMethod.GET,"/api/students/**").hasAnyRole("STUDENT")
			.antMatchers(HttpMethod.GET,"/user/**").permitAll()
			.antMatchers("/**").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/signin").permitAll()
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/user/profile")
			.and()
			.logout()
			.logoutUrl("/logout")
		    .invalidateHttpSession(true)
	        .clearAuthentication(true)
	        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			.logoutSuccessUrl("/signin?logout")
			.and()
			.exceptionHandling().accessDeniedHandler(customAccessDeniedHandler);
		
		return http.build();		}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails nasserDetails = User.builder()
										.username("Ness")
											.password("ness")
												.roles("STUDENT")
													.build();
		
		UserDetails zoyaDetails = User.builder()
				.username("Zoya")
					.password("ness")
						.roles("ADMIN")
						.build();
	
		return new InMemoryUserDetailsManager(nasserDetails,zoyaDetails);
	}
	
	

//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.      //role based mapping 
//			csrf()
//			.disable()
//			.authorizeRequests()
//			.antMatchers("/","index","/css/**","/js/**").permitAll()
//			.antMatchers(HttpMethod.POST, "/api/students/**").hasRole(ADMIN.name())
//			.antMatchers(HttpMethod.PUT, "/api/students/**").hasRole(ADMIN.name())
//			.antMatchers(HttpMethod.DELETE, "/api/students/**").hasRole(ADMIN.name())
//			.antMatchers(HttpMethod.GET, "/api/students/**").hasAnyRole(ADMIN.name(),TEACHER.name())
//			.antMatchers("api/admin/**").hasRole(ADMIN.name())
//			.anyRequest()
//			.authenticated()
//			.and()
//			.formLogin()
//			.loginPage("/login").permitAll()
//			.defaultSuccessUrl("/api/students")
//			.and()
//			.rememberMe()
//			.tokenValiditySeconds((int)TimeUnit.DAYS.toSeconds(21))//will expire in 21 days
//			.key("rem-me-key")// store hashvalue of username,session id with this key in db
//			.and()
//			.logout()
//			.logoutUrl("/logout")
//			.logoutSuccessUrl("/login");
//		
//		return http.build();
//	}
	
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public SimpleUrlAuthenticationFailureHandler failureHandler() {
	    return new SimpleUrlAuthenticationFailureHandler("/signin?error");
	}


}
