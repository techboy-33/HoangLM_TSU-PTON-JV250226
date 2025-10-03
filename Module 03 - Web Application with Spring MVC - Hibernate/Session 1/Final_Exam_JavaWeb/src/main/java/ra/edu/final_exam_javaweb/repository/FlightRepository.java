package ra.edu.final_exam_javaweb.repository;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ra.edu.final_exam_javaweb.model.entity.Flight;
import ra.edu.final_exam_javaweb.service.FlightService;

import javax.swing.*;
import java.util.List;

@Repository
public class FlightRepository {

    @Autowired
    private FlightService flightService;
    @Autowired
    private SessionFactory sessionFactory;

    public List<Flight> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Flight", Flight.class).list();
    }

    public List<Flight> searchFlights(String flightName, String startingPoint, String destination) {
        Session session = sessionFactory.getCurrentSession();
        String hql = "from Flight where 1=1";

        if (startingPoint != null && !startingPoint.isEmpty()) {
            hql += " and startingPoint like :startingPoint";
        }
        if (destination != null && !destination.isEmpty()) {
            hql += " and destination like :destination";
        }
        if (flightName != null && !flightName.isEmpty()) {
            hql += " and flightName like :flightName";
        }

        Query<Flight> query = session.createQuery(hql, Flight.class);
        if (startingPoint != null && !startingPoint.isEmpty()) {
            query.setParameter("startingPoint", startingPoint);
        }
        if (destination != null && !destination.isEmpty()) {
            query.setParameter("destination", destination);
        }
        if (flightName != null && !flightName.isEmpty()) {
            query.setParameter("flightName", "%" + flightName +"%");
        }


        return query.list();
    }

    public boolean save(Flight flight) {
        Session session = sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(flight);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Flight findById (Long id) {
        Session session = sessionFactory.getCurrentSession();
        try {
            return session.get(Flight.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public boolean delete (Long id) {
        Session session = sessionFactory.getCurrentSession();
        Flight flight = findById(id);
        if (flight != null) {
            session.delete(flight);
            return true;
        } else {
            return false;
        }
    }

    public boolean existsByFlightName(String flightName) {
        Session session = sessionFactory.getCurrentSession();
        Flight flight = session.createQuery("from Flight where flightName = :flightName", Flight.class).setParameter("flightName", flightName).uniqueResult();
        return flight != null;
    }
}
