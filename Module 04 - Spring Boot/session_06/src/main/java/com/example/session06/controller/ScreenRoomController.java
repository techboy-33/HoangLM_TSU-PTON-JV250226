package com.example.session06.controller;

import com.example.session06.model.dto.ScreenRoomDTO;
import com.example.session06.model.entity.ScreenRoom;
import com.example.session06.service.ScreenRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/screenRooms")
public class ScreenRoomController {
    @Autowired
    private ScreenRoomService screenRoomService;

    @GetMapping
    public List<ScreenRoom> getAllScreenRooms() {
        return screenRoomService.getAllScreenRooms();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addScreenRoom(@RequestBody ScreenRoomDTO screenRoomDTO) {
        ScreenRoom screenRoom = screenRoomService.addScreenRoom(screenRoomDTO);
        if (screenRoom != null) {
            return new ResponseEntity<>(screenRoom, HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("add screenRoom failed", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<?> updateScreenRoom(@PathVariable Long id, @RequestBody ScreenRoomDTO screenRoomDTO) {
        ScreenRoom updatedScreenRoom = screenRoomService.updateScreenRoom(id, screenRoomDTO);
        if (updatedScreenRoom != null) {
            return new ResponseEntity<>(updatedScreenRoom, HttpStatus.OK);
        }else {
            return new ResponseEntity<>("update screenRoom failed", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteScreenRoom(@PathVariable Long id) {
       boolean rs = screenRoomService.deleteScreenRoom(id);
       if (rs){
           return new ResponseEntity<>("delete successful", HttpStatus.OK);
       }else {
           return new ResponseEntity<>("delete failed", HttpStatus.BAD_REQUEST);
       }
    }
}
