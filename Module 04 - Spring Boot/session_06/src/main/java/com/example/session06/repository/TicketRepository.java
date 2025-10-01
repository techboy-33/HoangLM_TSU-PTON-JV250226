package com.example.session06.repository;

import com.example.session06.model.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
    List<Ticket> findByShowtimeId(Long showtimeId);
    @Query("select t from Ticket t where t.id = :id")
    Ticket findById(@Param("id") String id);
}
