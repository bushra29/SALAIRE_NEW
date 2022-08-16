package org.projet.SALAIRE;

import org.projet.SALAIRE.security.entities.Role;
import org.projet.SALAIRE.security.repositories.RoleRepository;
import org.projet.SALAIRE.security.requests.RegisterRequest;
import org.projet.SALAIRE.security.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SalaireApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaireApplication.class, args);
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public CommandLineRunner runner(UserService userService, RoleRepository roleRepository) {
		return args -> {
			/*Role role = new Role();
			role.setName("ROLE_ADMIN");
			roleRepository.save(role);
			Role role1 = new Role();
			role1.setName("ROLE_USER");
			roleRepository.save(role1);
			Role role2 = new Role();*/

			/*RegisterRequest request = new RegisterRequest();
			request.setUsername("admin123");
			request.setPassword("password");
			//request.setRoleName("ROLE_ADMIN");
			userService.storeUser(request);*/

			/*RegisterRequest request = new RegisterRequest();
			request.setUsername("user123");
			request.setPassword("password1");
			//request.setRoleName("ROLE_ADMIN");
			userService.storeUser(request);*/
		};
	}

}
