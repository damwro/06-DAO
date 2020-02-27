package DAO;

import entity.Driver;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class DriverDAO extends AbstractDAO implements DAOInterface<Driver> {

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
    public void save(Driver driver) {
        Session currentSession = getCurrentSession();
        currentSession.save(driver);
        commitTransaction(currentSession);

    }

    @Override
    public void update(Driver driver) {
        Session currentSession = getCurrentSession();
        Driver databaseDriver = currentSession.get(Driver.class, driver.getId());
        if (databaseDriver != null) {
            currentSession.update(databaseDriver);
        }
        commitTransaction(currentSession);
    }

    @Override
    public void delete(Driver driver) {
        Session currentSession = getCurrentSession();
        currentSession.delete(driver);
        commitTransaction(currentSession);
    }
}
