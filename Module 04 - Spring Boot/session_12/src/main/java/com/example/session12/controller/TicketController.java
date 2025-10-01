package com.example.session12.controller;

import com.example.session12.model.dto.request.TicketDTO;
import com.example.session12.model.dto.response.DataResponse;
import com.example.session12.model.entity.Ticket;
import com.example.session12.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<DataResponse<Page<Ticket>>> findAll(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    ){
        return ticketService.findAll(PageRequest.of(page, size));
    }

    @PostMapping("/add")
    public ResponseEntity<DataResponse<?>> add(@Valid @RequestBody TicketDTO ticketDTO){
        return ticketService.createTicket(ticketDTO);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<DataResponse<?>> updateTicket(@Valid @RequestBody TicketDTO ticketDTO, @PathVariable long id){
        return ticketService.updateTicket(ticketDTO,id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DataResponse<?>> deleteTicket(@PathVariable long id) {
        return ticketService.deleteTicket(id);
    }
}
