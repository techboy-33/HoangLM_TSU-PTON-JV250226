package com.example.session12.service;

import com.example.session12.model.dto.request.TicketDTO;
import com.example.session12.model.dto.response.DataResponse;
import com.example.session12.model.entity.Ticket;
import com.example.session12.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    private final Logger logger = LoggerFactory.getLogger(TicketService.class);

    public ResponseEntity<DataResponse<?>> createTicket(TicketDTO ticketDTO) {
        Ticket ticket = Ticket.builder()
                .ticketName(ticketDTO.getTicketName())
                .description(ticketDTO.getDescription())
                .price(ticketDTO.getPrice())
                .build();
        try {
            Ticket newTicket = ticketRepository.save(ticket);
            DataResponse<Ticket> dataResponse = DataResponse
                    .<Ticket>builder()
                    .message("Create ticket successful ")
                    .data(newTicket)
                    .status(201)
                    .build();
            return ResponseEntity.status(201).body(dataResponse);
        } catch (Exception e) {
            logger.error(e.getMessage());
            DataResponse<String> dataResponse = DataResponse
                    .<String>builder()
                    .message("Create ticket failed: " + e.getMessage())
                    .status(400)
                    .build();
            return ResponseEntity.status(400).body(dataResponse);
        }
    }

    public Ticket findById(long id) {
        return ticketRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Ticket not found"));
    }

    public ResponseEntity<DataResponse<?>> updateTicket(TicketDTO ticketDTO,long id) {
        Ticket ticket = findById(id);
        if (ticket == null) {
            DataResponse<String> dataResponse = DataResponse
                    .<String>builder()
                    .message("Ticket not found")
                    .status(404)
                    .build();
            return ResponseEntity.status(404).body(dataResponse);
        }else {
            ticket.setTicketName(ticketDTO.getTicketName());
            ticket.setDescription(ticketDTO.getDescription());
            ticket.setPrice(ticketDTO.getPrice());
            try {
                Ticket updatedTicket = ticketRepository.save(ticket);
                DataResponse<Ticket> dataResponse = DataResponse
                        .<Ticket>builder()
                        .message("Update ticket successful ")
                        .data(updatedTicket)
                        .status(200)
                        .build();
                return ResponseEntity.status(200).body(dataResponse);
            } catch (Exception e) {
                logger.error(e.getMessage());
                DataResponse<String> dataResponse = DataResponse
                        .<String>builder()
                        .message("Update ticket failed: " + e.getMessage())
                        .status(400)
                        .build();
                return ResponseEntity.status(400).body(dataResponse);
            }
        }
    }

    public ResponseEntity<DataResponse<?>> deleteTicket(long id) {
        Ticket ticket = findById(id);
        if (ticket == null) {
            DataResponse<String> dataResponse = DataResponse
                    .<String>builder()
                    .message("Ticket not found")
                    .status(404)
                    .build();
            return ResponseEntity.status(404).body(dataResponse);
        }else {
            try {
                ticketRepository.delete(ticket);
                DataResponse<String> dataResponse = DataResponse
                        .<String>builder()
                        .message("Delete ticket successful ")
                        .status(200)
                        .build();
                return ResponseEntity.status(200).body(dataResponse);
            } catch (Exception e) {
                logger.error(e.getMessage());
                DataResponse<String> dataResponse = DataResponse
                        .<String>builder()
                        .message("Delete ticket failed: " + e.getMessage())
                        .status(400)
                        .build();
                return ResponseEntity.status(400).body(dataResponse);
            }
        }
    }

    public ResponseEntity<DataResponse<Page<Ticket>>> findAll(Pageable pageable) {
        DataResponse<Page<Ticket>> dataResponse = DataResponse
                .<Page<Ticket>>builder()
                .message("Find all tickets successful")
                .data(ticketRepository.findAll(pageable))
                .status(200)
                .build();
        return ResponseEntity.status(200).body(dataResponse);
    }
}
