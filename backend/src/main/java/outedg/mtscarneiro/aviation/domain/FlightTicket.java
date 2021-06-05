package outedg.mtscarneiro.aviation.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FlightTicket implements Serializable {

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client passenger;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    private Payment payment;

    public Client getPassenger() {
        return passenger;
    }

    public void setPassenger(Client passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlightTicket that = (FlightTicket) o;
        return Objects.equals(passenger, that.passenger) && Objects.equals(flight, that.flight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(passenger, flight);
    }
}
