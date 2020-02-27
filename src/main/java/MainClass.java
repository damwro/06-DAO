import DAO.DriverDAO;
import entity.Driver;

import java.util.Optional;

public class MainClass {

    public static void main(String[] args) {
        DriverDAO dao = new DriverDAO();

        Optional<Driver> driver = dao.get(1L);

        driver.ifPresent(value -> System.out.println(value.getFirstName()));

        dao.save(new Driver("Jan", "Turek"));
    }
}
