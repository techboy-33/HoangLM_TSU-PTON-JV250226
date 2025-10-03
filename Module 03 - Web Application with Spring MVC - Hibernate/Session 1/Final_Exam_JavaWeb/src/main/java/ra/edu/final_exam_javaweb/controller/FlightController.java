package ra.edu.final_exam_javaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ra.edu.final_exam_javaweb.model.entity.Flight;
import ra.edu.final_exam_javaweb.service.FlightService;

import java.util.List;


@Controller
@RequestMapping("/flights")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping
    public String searchFlights(
            @RequestParam(value = "flightName", required = false) String flightName,
            @RequestParam(value = "startingPoint",  required = false) String startingPoint,
            @RequestParam(value = "destination",  required = false) String destination,
            Model model) {

        List<Flight> flights;
        if ((flightName != null && !flightName.isEmpty()) ||
                (startingPoint != null && !startingPoint.isEmpty()) ||
                (destination != null && !destination.isEmpty())
        ) {
            flights = flightService.searchFlights(flightName, startingPoint, destination);
        } else {
            flights = flightService.findAll();
        }
        model.addAttribute("flights", flights);
        model.addAttribute("flightName", flightName);
        model.addAttribute("startingPoint", startingPoint);
        model.addAttribute("destination", destination);
        return "listFlights";
    }

    @GetMapping("/add")
    public String showAddFlight(Model model) {
        if (!model.containsAttribute("flight")) {
            model.addAttribute("flight", new Flight());
        }
        return "addFlight";
    }

    @PostMapping("/add")
    public String addFlight(@ModelAttribute Flight flight, Model model, RedirectAttributes redirectAttributes) {
        if (flight.getFlightName() == null || flight.getFlightName().isEmpty()) {
            model.addAttribute("flight", flight);
            model.addAttribute("error", "Tên danh mục không được để trống.");
            return "addFlight";
        } else if (flightService.existsByFlightName(flight.getFlightName())) {
            model.addAttribute("flight", flight);
            model.addAttribute("error", "Tên danh mục đã tồn tại.");
            return "addFlight";
        }
        flightService.save(flight);
        redirectAttributes.addFlashAttribute("message", "Thêm chuyến bay thành công !");
        return "redirect:/flights";
    }

    @GetMapping("/edit/{flightId}")
    public String showEditFlight(@PathVariable("flightId") Long id, Model model) {
        Flight flight = flightService.findById(id);
        model.addAttribute("flight", flight);
        return "addFlight";
    }

    @PostMapping("/edit/{flightId}")
    public String editFlight(@PathVariable("flightId") Long id, @ModelAttribute Flight flight, Model model) {
        Flight oldFlight = flightService.findById(id);
        if (flightService.existsByFlightName(flight.getFlightName()) && !flight.getFlightId().equals(id)) {
            model.addAttribute("error", "Tên danh mục đã tồn tại.");
            return "editFlight";
        } else if (flightService.existsByFlightName(flight.getFlightName()) && !oldFlight.getFlightName().equals(flight.getFlightName())) {
            model.addAttribute("flight", flight);
            model.addAttribute("error", "Tên danh mục đã tồn tại. ");
            return "editFlight";
        }
        flight.setFlightId(id);
        flightService.save(flight);
        model.addAttribute("message", "Cập nhật chuyến bay thành công.");
        return "redirect:/flights";
    }

    @GetMapping("/delete/{flightId}")
    public String deleteFlight(@PathVariable("flightId") Long id) {
        flightService.deleteById(id);
        return "redirect:/flights";
    }
}
