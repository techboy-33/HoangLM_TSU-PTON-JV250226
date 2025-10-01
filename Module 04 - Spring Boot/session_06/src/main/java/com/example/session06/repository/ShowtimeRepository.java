package com.example.session06.repository;

import com.example.session06.model.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowtimeRepository extends JpaRepository<Showtime,Long> {
}
