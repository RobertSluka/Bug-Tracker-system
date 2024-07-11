package main.java.Bug;


import main.java.Bug.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication

public class BugTrackerSystemApplication {



    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(BugTrackerSystemApplication.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // This applies CORS to all endpoints
                        .allowedOrigins("http://localhost:3000") // Specify allowed origins
                        .allowedMethods("GET", "POST", "PUT", "DELETE") // Specify allowed methods
                        .allowedHeaders("*") // Allow all headers
                        .allowCredentials(true); // Allow credentials (e.g., cookies)
            }
        };
    }

}