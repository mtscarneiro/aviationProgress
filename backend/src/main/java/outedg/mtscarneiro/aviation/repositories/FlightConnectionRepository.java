package outedg.mtscarneiro.aviation.repositories;

import outedg.mtscarneiro.aviation.domain.FlightConnection;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightConnectionRepository extends JpaRepository<FlightConnection, Long> {
}
