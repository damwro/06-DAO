import DAO.DriverDAO;
import DAO.DriverDAOInterface;
import entity.Driver;

import java.util.List;
import java.util.Optional;

public class MainClass {

    public static void main(String[] args) {

        DriverDAOInterface<Driver> driverDAO = new DriverDAO();

        Optional driver = driverDAO.get(1L);

        driver.ifPresent(value -> System.out.println(((Driver)value).getFirstName()));

        driverDAO.save(new Driver("Kamil", "Turek"));

        List<Driver> turek = driverDAO.getDriverbyLastName("Turek");

        if(turek.size()>0){
            System.out.println("Pobrano poprzez DriverDAO");
            turek.forEach(System.out::println);
        }
    }
}
