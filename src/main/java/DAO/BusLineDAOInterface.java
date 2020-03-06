package DAO;

public interface BusLineDAOInterface<Passenger> extends DAOInterface {

    void createBusLineAndPassenger(String firstName, String lastname, String busLine);
}
