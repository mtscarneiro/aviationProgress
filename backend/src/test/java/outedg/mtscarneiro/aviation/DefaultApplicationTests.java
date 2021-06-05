package outedg.mtscarneiro.aviation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import outedg.mtscarneiro.aviation.domain.Client;
import outedg.mtscarneiro.aviation.domain.Flight;
import outedg.mtscarneiro.aviation.domain.FlightConnection;

import java.time.LocalDate;

@SpringBootTest
class DefaultApplicationTests {

	@Test
	void checkIfApiClientWorks() {
		Client client = new Client();
		client.setName("Matheus");
		client.setEmail("mtscar23@gmail.com");
		client.setPhone("67 99111-9603");
		client.setBirthDate(LocalDate.of(1997, 01, 23));
		client.age(client.getBirthDate());
		client.setDeficient(false);
		client.setFlight(new Flight(null, "Manaus", LocalDate.now(),
				new FlightConnection(null, null)));

		System.out.println(client);
	}

}
