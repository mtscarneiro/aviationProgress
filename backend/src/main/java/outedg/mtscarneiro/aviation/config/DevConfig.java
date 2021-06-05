package outedg.mtscarneiro.aviation.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import outedg.mtscarneiro.aviation.domain.Client;
import outedg.mtscarneiro.aviation.domain.Flight;
import outedg.mtscarneiro.aviation.domain.FlightConnection;
import outedg.mtscarneiro.aviation.domain.Payment;
import outedg.mtscarneiro.aviation.repositories.ClientRepository;
import outedg.mtscarneiro.aviation.repositories.FlightConnectionRepository;
import outedg.mtscarneiro.aviation.repositories.FlightRepository;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
@Profile("dev")
public class DevConfig implements CommandLineRunner {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private FlightConnectionRepository connectionRepository;

    @Override
    public void run(String... args) throws Exception {
        Client client1 = new Client(null, "Matheus",
                LocalDate.of(1997, 1, 23),
                false, "67 99111-9603",
                "mtscar23@gmail.com", null);

        Client client2 = new Client(null, "Apollo",
                LocalDate.of(2015, 6, 15),
                false, "67 99111-9603",
                "mtscar23@gmail.com", null);

        FlightConnection connection1 = new FlightConnection(null,
                "Brasilia");

        FlightConnection connection2 = new FlightConnection(null,
                "Sao Paulo");


        Flight a1001 = new Flight(null, "Manaus", LocalDate.now(),
                connection1, Payment.ORDERED);

        Flight a1002 = new Flight(null, "Rio de Janeiro", LocalDate.of(2021, 9, 30),
                connection2, Payment.PAID);

        connectionRepository.saveAll(Arrays.asList(connection1, connection2));
        
        flightRepository.saveAll(Arrays.asList(a1001, a1002));

        client1.setFlight(a1001);
        client2.setFlight(a1002);

        clientRepository.saveAll(Arrays.asList(client1, client2));

        }
}
