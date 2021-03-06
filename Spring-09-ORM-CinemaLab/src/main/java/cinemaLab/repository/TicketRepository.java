package cinemaLab.repository;

import cinemaLab.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // ------------------- DERIVED QUERIES ------------------- //

}
