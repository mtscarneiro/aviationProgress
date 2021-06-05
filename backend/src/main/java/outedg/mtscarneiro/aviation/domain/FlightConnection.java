package outedg.mtscarneiro.aviation.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_connections")
public class FlightConnection implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String connection;

    public FlightConnection() {}

    public FlightConnection(Long id, String connection) {
        this.id = id;
        this.connection = connection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
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
