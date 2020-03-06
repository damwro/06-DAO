package DAO;

import entity.BusLine;
import entity.Passenger;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class BusLineDAO extends AbstractDAO implements BusLineDAOInterface<BusLine> {


    public BusLineDAO() {
    }

    @Override
    public void createBusLineAndPassenger(String firstName, String lastname, String busLine) {

        BusLine busLineToSave = new BusLine(busLine);
        System.out.println("----Zapisuję BusLine----");

        //stwórz i zapisz Passenger
        Passenger passenger = new Passenger(firstName, lastname);

        //dodaj pasażerów do linii
        busLineToSave.addPassenger(passenger);

        //zapisz Passenger
        System.out.println("----Zapisuję Pasażerów----");
        save(passenger);
        save(busLineToSave);
    }

    @Override
    public Optional get(long id) {
        Session currentSession = getCurrentSession();
        Passenger passenger = currentSession.get(Passenger.class, id);
        commitTransaction(currentSession);

        return Optional.of(passenger);

    }

    @Override
    public List getAll() {
        Session currentSession = getCurrentSession();
        List<Passenger> passengers = currentSession.createQuery("from Passenger s").getResultList();
        commitTransaction(currentSession);
        return passengers;
    }

    @Override
    public void save(Object o) {
        Session currentSession = getCurrentSession();
        currentSession.save(o);
        commitTransaction(currentSession);

    }

    @Override
    public void update(Object o) {
        Session currentSession = getCurrentSession();
        Passenger databasePassenger = currentSession.get(Passenger.class, ((Passenger) o).getId());
        if (databasePassenger != null) {
            currentSession.update(o);
        }
        commitTransaction(currentSession);

    }

    @Override
    public void delete(Object o) {
        Session currentSession = getCurrentSession();
        currentSession.delete(o);
        commitTransaction(currentSession);
    }
}
