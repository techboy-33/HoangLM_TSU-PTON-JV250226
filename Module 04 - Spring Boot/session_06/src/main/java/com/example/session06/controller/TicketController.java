package com.example.session06.controller;

import com.example.session06.model.dto.TicketDTO;
import com.example.session06.model.entity.Ticket;
import com.example.session06.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return new ResponseEntity<>(ticketService.getAllTickets(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTicket(@RequestBody TicketDTO ticketDTO) {
        Ticket ticket = ticketService.addTicket(ticketDTO);
        if (ticket != null) {
            return new ResponseEntity<>(ticket, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("add ticket failed !" , HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping ("/findAllByShowtime/{id}")
    public ResponseEntity<List<Ticket>> findAllByShowtime(@PathVariable Long id) {
        return new ResponseEntity<>(ticketService.findAllByShowtime(id), HttpStatus.OK);
    }

    @GetMapping("/searchById")
    public ResponseEntity<?> searchById(@RequestParam("id") String id) {
        Ticket ticket = ticketService.findById(id);
        if (ticket != null) {
            return new ResponseEntity<>(ticket, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("ticket not found !" , HttpStatus.BAD_REQUEST);
        }

    }
}
