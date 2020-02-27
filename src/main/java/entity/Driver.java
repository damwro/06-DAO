package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "driver")
public class Driver  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_detail_id")
    private DriverDetail driverDetail;

    @OneToMany(mappedBy = "driver",
            cascade = {
                    CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
            })
    private List<BusLine> busLines;

    public Driver() {
    }

    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DriverDetail getDriverDetail() {
        return driverDetail;
    }

    public void setDriverDetail(DriverDetail driverDetail) {
        this.driverDetail = driverDetail;
    }

    public List<BusLine> getBusLines() {
        return busLines;
    }

    public void setBusLines(List<BusLine> busLines) {
        this.busLines = busLines;
    }

    /**
     * dodawanie linii, którą obsługuje kierowca
     *
     * @param busLine linia autobusowo-tramwajowa
     */
    public void addBusLine(BusLine busLine) {
        if (busLines == null) {
            busLines = new ArrayList<>();
        }
        busLines.add(busLine);
        busLine.setDriver(this);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + getId() +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", driverDetail=" + driverDetail +
                '}';
    }
}
