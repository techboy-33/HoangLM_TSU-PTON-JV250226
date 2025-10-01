package com.example.session06.controller;

import com.example.session06.model.dto.ShowtimeDTO;
import com.example.session06.model.entity.Showtime;
import com.example.session06.service.ShowtimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/showtimes")
public class ShowtimeController {
    @Autowired
    private ShowtimeService showtimeService;

    @GetMapping
    public ResponseEntity<List<Showtime>> getAllShowtimes() {
        return new ResponseEntity<>(showtimeService.getAllShowtimes(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addShowtime(@RequestBody ShowtimeDTO showtimeDTO) {
        Showtime showtime = showtimeService.addShowtime(showtimeDTO);
        if (showtime != null) {
            return new ResponseEntity<>(showtime, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("add showtime failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateShowtime(@PathVariable Long id, @RequestBody ShowtimeDTO showtimeDTO) {
        Showtime updatedShowtime = showtimeService.updateShowtime(id, showtimeDTO);
        if (updatedShowtime != null) {
            return new ResponseEntity<>(updatedShowtime, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("update showtime failed !" , HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteShowtime(@PathVariable Long id) {
      boolean rs =  showtimeService.deleteShowtime(id);
        if (rs){
            return new ResponseEntity<>("delete showtime successfully !" , HttpStatus.OK);
        }else {
            return new ResponseEntity<>("delete showtim failed !" , HttpStatus.BAD_REQUEST);
        }
    }
}
