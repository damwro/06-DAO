package DAO;

import entity.Driver;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class DriverDAO extends AbstractDAO implements DriverDAOInterface<Driver> {

    public DriverDAO() {
    }

    @Override
    public Optional<Driver> get(long id) {

        Session currentSession = getCurrentSession();
        Driver driver = currentSession.get(Driver.class, id);
        commitTransaction(currentSession);

        return Optional.of(driver);
    }

    @Override
    public List<Driver> getAll() {
        Session currentSession = getCurrentSession();
        List<Driver> drivers = currentSession.createQuery("from Driver s").getResultList();
        commitTransaction(currentSession);
        return drivers;
    }

    @Override
    public void save(Object driver) {
        Session currentSession = getCurrentSession();
        currentSession.save((Driver) driver);
        commitTransaction(currentSession);

    }

    @Override
    public void update(Object driver) {
        Session currentSession = getCurrentSession();
        Driver databaseDriver = currentSession.get(Driver.class, ((Driver) driver).getId());
        if (databaseDriver != null) {
            currentSession.update(driver);
        }
        commitTransaction(currentSession);
    }

    @Override
    public void delete(Object driver) {
        Session currentSession = getCurrentSession();
        currentSession.delete(driver);
        commitTransaction(currentSession);
    }

    @Override
    public List<Driver> getDriverbyLastName(String lastName) {
        Session currentSession = getCurrentSession();
        List resultList = currentSession.createQuery("from Driver d where d.lastName = '" + lastName + "'").getResultList();

        return resultList;
    }
}
