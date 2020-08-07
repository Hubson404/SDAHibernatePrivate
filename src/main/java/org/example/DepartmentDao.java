package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DepartmentDao {

    private HibernateFactory hibernateFactory = new HibernateFactory();

    public List<Department> getAll() {

        Session session = hibernateFactory.getSessionFactory().openSession();
        List<Department> departments = session
                .createQuery("From Department", Department.class).list();
        session.close();

        return departments;
    }

    public Department get(int Id) {

        Department department;
        Session session = hibernateFactory.getSessionFactory().openSession();
        department = (Department) session.get(Department.class, Id);
        session.close();

        return department;
    }

    public void save(Department department) {

        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(department);
        tx.commit();
        session.close();
    }

    public void update(Department department) {

        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(department);
        tx.commit();
        session.close();

    }

    public void delete(Department department) {

        Session session = hibernateFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.delete(department);
        tx.commit();
        session.close();

    }




}
