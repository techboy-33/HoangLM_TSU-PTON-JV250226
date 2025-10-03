package ra.edu.final_exam_javaweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ra.edu.final_exam_javaweb.model.entity.Flight;
import ra.edu.final_exam_javaweb.repository.FlightRepository;

import java.util.List;


@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Transactional(readOnly = true)
    public List<Flight> findAll () {
        return flightRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Flight> searchFlights (String flightName, String startingPoint, String destination) {
        return flightRepository.searchFlights(flightName, startingPoint, destination);
    }

    @Transactional
    public boolean save(Flight flight) {
        return flightRepository.save(flight);
    }

    @Transactional(readOnly = true)
    public Flight findById (Long id) {
        return flightRepository.findById(id);
    }

    @Transactional
    public boolean deleteById (Long id) {
        return flightRepository.delete(id);
    }

    @Transactional
    public boolean existsByFlightName(String flightName) {
        return flightRepository.existsByFlightName(flightName);
    }
}
