package outedg.mtscarneiro.aviation.repositories;

import outedg.mtscarneiro.aviation.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
