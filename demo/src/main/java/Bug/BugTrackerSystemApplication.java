package Bug;


import Bug.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"Bug.Repository"})
public class BugTrackerSystemApplication {



	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BugTrackerSystemApplication.class, args);
	}


}
