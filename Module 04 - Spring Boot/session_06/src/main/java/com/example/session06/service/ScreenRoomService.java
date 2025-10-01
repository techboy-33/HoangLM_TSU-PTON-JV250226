package com.example.session06.service;

import com.example.session06.model.dto.ScreenRoomDTO;
import com.example.session06.model.entity.ScreenRoom;
import com.example.session06.repository.ScreenRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ScreenRoomService {
    @Autowired
    private ScreenRoomRepository screenRoomRepository;
    @Autowired
    private CinemaService cinemaService;

    public List<ScreenRoom> getAllScreenRooms() {
        return screenRoomRepository.findAll();
    }

    public ScreenRoom getScreenRoomById(Long id) {
        return screenRoomRepository.findById(id).orElseThrow(() -> new NoSuchElementException("ScreenRoom not found"));
    }

    public ScreenRoom addScreenRoom(ScreenRoomDTO screenRoomDTO) {
        try {
            return screenRoomRepository.save(convertScreenRoomDTOToScreenRoom(screenRoomDTO));
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public ScreenRoom updateScreenRoom(Long id, ScreenRoomDTO screenRoomDTO) {
       ScreenRoom oldScreenRoom = getScreenRoomById(id);
       if (oldScreenRoom != null) {
           ScreenRoom newScreenRoom = convertScreenRoomDTOToScreenRoom(screenRoomDTO);
           newScreenRoom.setId(oldScreenRoom.getId());
           try {
               return screenRoomRepository.save(newScreenRoom);
           } catch (Exception e) {
               e.printStackTrace();
               return null;
           }
       }else {
           return null;
       }
    }

    public boolean deleteScreenRoom(Long id) {
        ScreenRoom oldScreenRoom = getScreenRoomById(id);
        if (oldScreenRoom != null) {
            try {
                screenRoomRepository.delete(oldScreenRoom);
                return true;
            }catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }else {
            return false;
        }
    }

    public ScreenRoom convertScreenRoomDTOToScreenRoom(ScreenRoomDTO screenRoomDTO) {
        return ScreenRoom
                .builder()
                .capacity(screenRoomDTO.getCapacity())
                .cinema(cinemaService.getCinemaById(screenRoomDTO.getCinemaId()))
                .name(screenRoomDTO.getName())
                .type(screenRoomDTO.getType())
                .build();
    }
}