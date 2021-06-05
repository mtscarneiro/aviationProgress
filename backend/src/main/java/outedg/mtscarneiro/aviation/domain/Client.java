package outedg.mtscarneiro.aviation.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "tb_clients")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate birthDate;
    private Boolean deficient;
    private String phone;
    private String email;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    public Client(){}

    public Client(Long id, String name, LocalDate birthDate, Boolean deficient, String phone, String email) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.deficient = deficient;
        this.phone = phone;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Boolean getDeficient() {
        return deficient;
    }

    public void setDeficient(Boolean deficient) {
        this.deficient = deficient;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Integer age(LocalDate birthD) {
        LocalDate today = LocalDate.now();
        birthD = LocalDate.of(birthD.getYear(), birthD.getMonth(), birthD.getDayOfMonth());
        int old = Period.between(birthD, today).getYears();
        return old;
    }

    public boolean isDeficient() {
        if(getDeficient() == false) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", deficient=" + deficient +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", flight=" + flight +
                '}';
    }
}
