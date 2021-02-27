package cinemaLab;

import cinemaLab.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@SpringBootApplication
	public class CinemaappApplication {
		@Autowired
		AccountRepository accountRepository;



		@PostConstruct
		public void testAccount() {
			System.out.println(accountRepository.fetchAdminUsers());

		}
	}
}


