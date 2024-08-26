package com.apisRestfull.apisRestfull_hotel.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisRestfull.apisRestfull_hotel.controller.Dto.roomDto;
import com.apisRestfull.apisRestfull_hotel.models.Room;
import com.apisRestfull.apisRestfull_hotel.service.IroomService;

@RestController
@RequestMapping("/api/room")

public class roomController {
    @Autowired
    private IroomService iroomService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Room> roomOptional = iroomService.findById(id);

        if (roomOptional.isPresent()) {
            Room room = roomOptional.get();

            roomDto rDto = roomDto.builder()
                    .idroom(room.getIdroom())
                    .room_number(room.getRoom_number())
                    .room_type(room.getRoom_type())
                    .price(room.getPrice())
                    .status_room(room.getStatus_room())
                    .hotel(room.getHotel())
                    .build();

            return ResponseEntity.ok(rDto);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The room with the ID " + id + " not found in the database.");
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<roomDto>> findAll() {
        List<roomDto> roomDtoList = iroomService.findAll()
                .stream()
                .map(room -> roomDto.builder()
                        .idroom(room.getIdroom())
                        .room_number(room.getRoom_number())
                        .room_type(room.getRoom_type())
                        .price(room.getPrice())
                        .status_room(room.getStatus_room())
                        .hotel(room.getHotel())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(roomDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody roomDto rDto) throws URISyntaxException {
        if (rDto.getRoom_number().isBlank()||
        rDto.getRoom_type().isBlank() ||
        rDto.getPrice() == null|| 
        rDto.getStatus_room().isBlank() ||
        rDto.getHotel() == null) {

            return ResponseEntity.badRequest().build();
            
        }
        iroomService.save(Room.builder()
        .room_number(rDto.getRoom_number())
        .room_type(rDto.getRoom_type())
        .price(rDto.getPrice())
        .status_room(rDto.getStatus_room())
        .hotel(rDto.getHotel())
        .build());

        return ResponseEntity.created(new URI("/api/room/save")).build();

    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateRooom(@PathVariable long id, @RequestBody roomDto rDto){
        Optional<Room> optionalRoom = iroomService.findById(id);

        if (optionalRoom.isPresent()) {
            Room room = optionalRoom.get();

            
            room.setRoom_number(rDto.getRoom_number());
            room.setRoom_type(rDto.getRoom_type());
            room.setPrice(rDto.getPrice());
            room.setStatus_room(rDto.getStatus_room());

            iroomService.save(room);

            return ResponseEntity.ok("Register update");
            
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Optional<Room> optionalroom = iroomService.findById(id);

        if (optionalroom.isPresent()) {
            iroomService.deleteById(id);
            return ResponseEntity.ok("Register delete");
            
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body("The room with the ID " + id + " not found in the database.");
    }
}
