package java.Bug.Security;//package Bug.Security;
//
//import Bug.Security.CustomUsertDetailService;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.HttpStatusEntryPoint;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//    private JwtAuthEntryPoint authEntryPoint;
//
//    private CustomUsertDetailService usertDetailService;
//    @Autowired
//    public SecurityConfig(CustomUsertDetailService usertDetailService, JwtAuthEntryPoint authEntryPoint) {
//        this.usertDetailService = usertDetailService;
//        this.authEntryPoint = authEntryPoint;
//    }
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(AbstractHttpConfigurer::disable)
//
//                // Disable CSRF protection using the new API
//                .authorizeHttpRequests(authorize -> authorize
//                        .requestMatchers(HttpMethod.GET, "/api/auth/**").permitAll() // Allow GET requests to /api/auth/** without authentication
//                        .requestMatchers("/api/auth/**").permitAll() // Allow all requests to /api/auth/**
//                        .anyRequest().authenticated()
//                        // Authenticate all other requests
//                )
//
//                .httpBasic(Customizer.withDefaults()) // Enable HTTP Basic authentication
//                .sessionManagement(session -> session
//                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Use stateless sessions
//                )
//                .exceptionHandling(exception -> exception
//                        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))// Handle unauthorized access
//                );
//        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();
//    }
//
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration AuthenticationConfiguration, AuthenticationConfiguration authenticationConfiguration) throws  Exception{
//        return authenticationConfiguration.getAuthenticationManager();
//    }
//    @Bean
//
//    public PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
//
//  @Bean
//    public JWTAuthenticationFilter jwtAuthenticationFilter(){
//        return new JWTAuthenticationFilter();
//  }
//
//
//
//}
