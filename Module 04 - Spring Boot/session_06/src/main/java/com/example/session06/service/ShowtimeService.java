package com.example.session06.service;

import com.example.session06.model.dto.ShowtimeDTO;
import com.example.session06.model.entity.Showtime;
import com.example.session06.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ShowtimeService {
    @Autowired
    private ShowtimeRepository showtimeRepository;
    @Autowired
    private MovieService movieService;
    @Autowired
    private ScreenRoomService screenRoomService;

    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    public Showtime getShowtimeById(Long id) {
        return showtimeRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Show tim not found !"));
    }

    public Showtime addShowtime(ShowtimeDTO showtimeDTO) {
        try {
            return showtimeRepository.save(convertShowtimeDTOToShowtime(showtimeDTO));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Showtime updateShowtime(Long id, ShowtimeDTO showtimeDTO) {
        Showtime oldShowtime = getShowtimeById(id);
        if (oldShowtime != null) {
            Showtime newShowtime = convertShowtimeDTOToShowtime(showtimeDTO);
            newShowtime.setId(id);
            try {
               return showtimeRepository.save(newShowtime);
            }catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }else {
            return null;
        }
    }

    public boolean deleteShowtime(Long id) {
        Showtime showtime = getShowtimeById(id);
        if (showtime != null) {
            try {
                showtimeRepository.delete(showtime);
                return true;
            }catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else {
            return false;
        }
    }

    public Showtime convertShowtimeDTOToShowtime(ShowtimeDTO showtimeDTO){
        return Showtime
                .builder()
                .showtime(showtimeDTO.getShowtime())
                .movie(movieService.getMovieById(showtimeDTO.getMovieId()))
                .screenRoom(screenRoomService.getScreenRoomById(showtimeDTO.getScreenRoomId()))
                .build();
    }
}