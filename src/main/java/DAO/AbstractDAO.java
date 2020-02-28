package DAO;

import entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class AbstractDAO {

    private final static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
            .addAnnotatedClass(DriverDetail.class)
            .addAnnotatedClass(Driver.class)
            .addAnnotatedClass(BusLine.class)
            .addAnnotatedClass(Passenger.class)
            .addAnnotatedClass(VehicleOnLine.class)
            .buildSessionFactory();

    protected Session getCurrentSession() {
        Session currentSession = factory.getCurrentSession();
        currentSession.beginTransaction();
        return currentSession;
    }

    protected void commitTransaction(Session session) {
        session.getTransaction().commit();
    }

}
