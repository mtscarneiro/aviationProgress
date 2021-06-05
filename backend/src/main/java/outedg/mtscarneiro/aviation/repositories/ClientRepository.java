package outedg.mtscarneiro.aviation.repositories;

import outedg.mtscarneiro.aviation.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
