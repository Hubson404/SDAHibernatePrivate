package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class LocationDao {

    private HibernateFactory hibernateFactory = new HibernateFactory();

    public List<Location> getAll() {

        Session session = hibernateFactory.getSessionFactory().openSession();

        List<Location> locations = session
                .createQuery("From Location", Location.class).list();

        session.close();

        return locations;
    }

    public Location get(int Id) {

        Location location;
        Session session = hibernateFactory.getSessionFactory().openSession();

        location = (Location) session.get(Location.class, Id);

        session.close();

        return location;
    }

    public void save(Location location) {

        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(location);

        tx.commit();
        session.close();
    }

    public void update(Location location) {

        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.update(location);

        tx.commit();
        session.close();

    }

    public void delete(Location location) {

        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.delete(location);

        tx.commit();
        session.close();

    }

    public void delete(int locationId) {

        Location location;

        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        location = this.get(locationId);
        session.delete(location);

        tx.commit();
        session.close();

    }


}
