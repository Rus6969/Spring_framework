package cinemaLab;

import cinemaLab.repository.AccountRepository;
import cinemaLab.repository.CinemaRepository;
import cinemaLab.repository.MovieCinemaRepository;
import cinemaLab.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class DemoApplication {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	CinemaRepository cinemaRepository;
	@Autowired
	MovieCinemaRepository movieCinemaRepository;
	@Autowired
	TicketRepository ticketRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@PostConstruct
	public void testAccount(){
		System.out.println(accountRepository.fetchAdminUsers());
		//System.out.println(cinemaRepository.distinctBYSponsoredName());
		System.out.println(movieCinemaRepository.countAllByCinemaId(4L));
		System.out.println(movieCinemaRepository.retrieveAllByLocationName("AMC Empire 25"));
		System.out.println(ticketRepository.fetchAllTicketsByUserJPQL(4l));
		System.out.println(ticketRepository.fetchAllTicketsWithRangeDates(LocalDateTime.now().minusDays(25),LocalDateTime.now()));
		System.out.println(ticketRepository.retrieveAllBySearchCriteria("it"));
	}


}