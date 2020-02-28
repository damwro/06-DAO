package DAO;

import entity.Driver;

import java.util.List;

public interface DriverDAOInterface<Driver> extends DAOInterface {

    List<Driver> getDriverbyLastName(String lastName);
}
