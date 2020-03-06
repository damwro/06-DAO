import DAO.BusLineDAO;
import DAO.BusLineDAOInterface;
import DAO.DriverDAO;
import DAO.DriverDAOInterface;
import entity.BusLine;
import entity.Driver;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class ServiceClass {

    static final DriverDAOInterface<Driver> driverDAO = new DriverDAO();
    static final BusLineDAOInterface<BusLine> buslineDAO = new BusLineDAO();

    public static void main(String[] args) {

        getDriverById();

        saveDriver();

        getDriverByLastName();

        createBusLineAndPassenger();
    }

    private static void createBusLineAndPassenger() {
        System.out.println("Podaj imię pasażera");
        String firstName = getInput();
        System.out.println("Podaj nazwisko pasażera");
        String lastName = getInput();
        System.out.println("Podaj linię powiązaną z pasażerem");
        String line = getInput();
        buslineDAO.createBusLineAndPassenger(firstName,lastName,line);
    }


    private static void getDriverByLastName() {
        String searchName = getInput();
        List<Driver> drivers = driverDAO.getDriverbyLastName(searchName);
        System.out.println("\n");
        if (drivers.size() > 0) {
            System.out.println("Pobrano poprzez DriverDAO");
            drivers.forEach(System.out::println);
        }
    }

    private static void saveDriver() {
        System.out.println("Zapisz użytkownika:");
        System.out.println("Podaj imię:");
        String name = getInput();
        System.out.println("Podaj nazwisko:");
        String surname = getInput();
        driverDAO.save(new Driver(name, surname));
        System.out.println("\n");
    }

    private static void getDriverById() {
        System.out.println("Podaj id:");
        String id = getInput();
        Optional driver = driverDAO.get(Long.valueOf(id));
        System.out.println("\n");
        driver.ifPresent(value -> System.out.println(((Driver) value).getFirstName()));
    }

    private static String getInput() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        System.out.println("Wprowadzona wartość: " + input);
        return input;
    }
}
