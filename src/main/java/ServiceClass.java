import DAO.DriverDAO;
import DAO.DriverDAOInterface;
import entity.Driver;

import java.util.List;
import java.util.Optional;

public class ServiceClass {

    public static void main(String[] args) {

        DriverDAOInterface<Driver> driverDAO = new DriverDAO();

        Optional driver = driverDAO.get(1L);
        System.out.println("\n");

        driver.ifPresent(value -> System.out.println(((Driver)value).getFirstName()));
        System.out.println("\n");

        driverDAO.save(new Driver("Jerzy", "Turek"));
        System.out.println("\n");

        List<Driver> turek = driverDAO.getDriverbyLastName("Turek");
        System.out.println("\n");

        if(turek.size()>0){
            System.out.println("Pobrano poprzez DriverDAO");
            turek.forEach(System.out::println);
        }
    }
}
