package pl.uwm.faculty.facultative.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class CsrfConfig {


//    public class WebCsrfConfig extends WebSecurityConfigurerAdapter {
//
//        private static final String[] AUTH_WHITELIST = {
//                "/v2/api-docs",
//                "/swagger-resources",
//                "/swagger-resources/**",
//                "/configuration/ui",
//                "/configuration/security",
//                "/swagger-ui.html",
//                "/webjars/**",
//                "/v3/api-docs/**",
//                "/swagger-ui/**",
//                "/address/**",
//                "/users",
//                "/api/users/**",
//                "/items/**",
//                "/api/**",
//                "/**"
//        };
//
//        @Override
//        protected void configure(HttpSecurity http) throws Exception {
//            http
//                    .authorizeRequests()
//                    .antMatchers(AUTH_WHITELIST)
//                    .permitAll();
//        }
//
//        @Bean
//        CorsConfigurationSource corsConfigurationSource() {
//            CorsConfiguration configuration = new CorsConfiguration();
//            configuration.setAllowedOrigins(List.of("*"));
//            configuration.setAllowedMethods(List.of("*"));
//            configuration.setAllowedHeaders(List.of("*"));
//            configuration.setAllowCredentials(true);
//            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//            source.registerCorsConfiguration("/**", configuration);
//            return source;
//        }
//    }
}