package outedg.mtscarneiro.aviation.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_Flights")
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String destination;
    private LocalDate date;
    @Lob
    private FlightConnection connection;

    @JsonIgnore
    @OneToMany(mappedBy = "flight")
    private List<Client> clients = new ArrayList<>();

    public Flight(){

    }

    public Flight(Long id, String destination, LocalDate date, FlightConnection connection) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.connection = connection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public FlightConnection getConnection() {
        return connection;
    }

    public void setConnection(FlightConnection connection) {
        this.connection = connection;
    }

    public List<Client> getClients() {
        return clients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                ", connection=" + connection +
                ", clients=" + clients +
                '}';
    }
}
