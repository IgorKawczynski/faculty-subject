package pl.uwm.faculty.facultative.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
public class WebConfig {


    private static final String ADMIN = "ADMIN";
    private static final String CLIENT = "CLIENT";

    @Autowired
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails client = User
                .withUsername("client")
                .password("{noop}password")
                .roles(CLIENT)
                .build();

        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}password")
                .roles(ADMIN)
                .build();

        return new InMemoryUserDetailsManager(client, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers("/api/items/**").hasAnyRole("CLIENT")
                .antMatchers("/api/items/**").hasAnyRole("ADMIN")
                .antMatchers("/api/users/**").hasAnyRole("ADMIN")
                .antMatchers("/graphiql/**").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/auth/logout"))
                .and()
                .build();
    }
}
