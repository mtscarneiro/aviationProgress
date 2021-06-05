package outedg.mtscarneiro.aviation.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_connections")
public class FlightConnection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Flight connection;

    public FlightConnection() {}

    public FlightConnection(Long id, Flight connection) {
        this.id = id;
        this.connection = connection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getConnection() {
        return connection;
    }

    public void setConnection(Flight connection) {
        this.connection = connection;
    }

    @Override
    public String toString() {
        return "FlightConnection{" +
                "id=" + id +
                ", connection=" + connection +
                '}';
    }
}
