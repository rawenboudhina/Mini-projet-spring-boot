package com.rawen.plats.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests

				.requestMatchers("/supprimerPlat").hasAnyAuthority("ADMIN")
				// .requestMatchers("/modifierPlat", "/supprimerPlat").hasAnyAuthority("ADMIN")

				.requestMatchers("/modifierPlat").hasAnyAuthority("ADMIN", "USER2")

				.requestMatchers("/showCreate", "/saveProduit").hasAnyAuthority("ADMIN", "AGENT")

				.requestMatchers("/listePlats").hasAnyAuthority("ADMIN", "AGENT", "USER", "USER2")
//				si on enlève webjars le bootstrap ne marche pas car il web jars donne l'accès au fichiers css
				.requestMatchers("/login", "/webjars/**").permitAll()

				.anyRequest().authenticated())
				.formLogin((formLogin) -> formLogin.loginPage("/login").defaultSuccessUrl("/"))

				.httpBasic(Customizer.withDefaults())

				// .formLogin(Customizer.withDefaults())// c'est à dire il av prendre la page de
				// login par défaut de spring
				// security
				.httpBasic(Customizer.withDefaults())
				.exceptionHandling((exception) -> exception.accessDeniedPage("/accessDenied"));

		return http.build();// on retourne un objet SecurityFilterChain
	}

	// on met setUsersByUsernameQuery car on n'a pas utilisé la structure par défaut
	// de database spring security:
	// security database:schema
	/*
	 * @Bean public UserDetailsService userDetailsService(DataSource dataSource) {
	 * JdbcUserDetailsManager jdbcUserDetailsManager = new
	 * JdbcUserDetailsManager(dataSource);
	 * 
	 * jdbcUserDetailsManager
	 * .setUsersByUsernameQuery("select username , password , enabled from user where username =?"
	 * ); jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
	 * "SELECT u.username, r.role as authority   " +
	 * "FROM user_role ur, user u , role r " +
	 * "WHERE u.user_id = ur.user_id AND ur.role_id = r.role_id AND u.username = ?"
	 * );
	 * 
	 * return jdbcUserDetailsManager; }
	 */
	 @Bean public PasswordEncoder passwordEncoder() {
		 return new
	 BCryptPasswordEncoder(); }
	 
}

// bean c'est à dire singleton :Spring génère une seule instance de cet objet

/*
 * @Bean public InMemoryUserDetailsManager userDetailsService() {
 * PasswordEncoder passwordEncoder = passwordEncoder ();
 * 
 * // UserDetails admin = User.withDefaultPasswordEncoder().username("admin")
 * UserDetails admin = User.withUsername("admin")
 * 
 * .password(passwordEncoder.encode("123")) .authorities("ADMIN") .build(); //
 * UserDetails userNadhem = User.withDefaultPasswordEncoder().username("nadhem")
 * UserDetails userNadhem = User.withUsername("nadhem")
 * 
 * .password(passwordEncoder.encode("123")) .authorities("AGENT", "USER")
 * .build(); //UserDetails user1 =
 * //User.withDefaultPasswordEncoder().username("user1")
 * 
 * UserDetails user1 = User.withUsername ("user1")
 * 
 * .password(passwordEncoder.encode("123")) .authorities("USER") .build();
 * 
 * UserDetails user2 = User.withUsername ("user2")
 * .password(passwordEncoder.encode("123")) .authorities("USER2") .build();
 * 
 * return new InMemoryUserDetailsManager(admin, userNadhem, user2,user1); } }
 */