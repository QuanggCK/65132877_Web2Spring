package clc65.quanggck;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
				.formLogin(form -> form.permitAll().defaultSuccessUrl("/home", true))
				.logout(logout -> logout.permitAll().logoutSuccessUrl("/login?logout"))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
						.maximumSessions(1).maxSessionsPreventsLogin(true));

		return http.build();
	}
}