package com.example.session06.service;

import com.example.session06.model.dto.TicketDTO;
import com.example.session06.model.entity.Ticket;
import com.example.session06.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private ShowtimeService showtimeService ;


    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket addTicket(TicketDTO ticketDTO) {
        try {
            Ticket ticket = convertTicketDTOToTicket(ticketDTO);
            ticket.setId(ticket.generateTicketId());
            return ticketRepository.save(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Ticket> findAllByShowtime(Long showtimeId) {
        return ticketRepository.findByShowtimeId(showtimeId);
    }

    public Ticket findById(String id) {
        return ticketRepository.findById(id);
    }

    public Ticket convertTicketDTOToTicket(TicketDTO ticketDTO) {
        return Ticket
                .builder()
                .showtime(showtimeService.getShowtimeById(ticketDTO.getShowtimeId()))
                .username(ticketDTO.getUsername())
                .phoneNumber(ticketDTO.getPhoneNumber())
                .seatNumber(ticketDTO.getSeatNumber())
                .build();
    }
}
