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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisRestfull.apisRestfull_hotel.controller.Dto.reservationDto;
import com.apisRestfull.apisRestfull_hotel.models.Hotel;
import com.apisRestfull.apisRestfull_hotel.models.Reservation;
import com.apisRestfull.apisRestfull_hotel.models.Room;
import com.apisRestfull.apisRestfull_hotel.models.Userd;
import com.apisRestfull.apisRestfull_hotel.repository.hotelRepository;
import com.apisRestfull.apisRestfull_hotel.repository.roomRepository;
import com.apisRestfull.apisRestfull_hotel.repository.userdRepositoty;
import com.apisRestfull.apisRestfull_hotel.service.IreservationService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/reservation")
public class reservationController {
    
    @Autowired
    private IreservationService rService;

    @Autowired
    private hotelRepository hRepository;

    @Autowired
    private userdRepositoty uRepositoty;

    @Autowired
    private roomRepository repository;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Reservation> reservationOptional = rService.findById(id);

        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();

            reservationDto reDto = reservationDto.builder()
                    .idreservation(reservation.getIdreservation())
                    .entry_date(reservation.getEntry_date())
                    .date_out(reservation.getDate_out())
                    .userd(reservation.getUserd())
                    .hotel(reservation.getHotel())
                    .room(reservation.getRoom())
                    .build();

            return ResponseEntity.ok(reDto);

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The reservation with the ID " + id + " not found in the database.");
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<reservationDto>> findAll() {

        List<reservationDto> reservationDtoList = rService.findAll()
                .stream()
                .map(reservation -> reservationDto.builder()
                        .idreservation(reservation.getIdreservation())
                        .entry_date(reservation.getEntry_date())
                        .date_out(reservation.getDate_out())
                        .userd(reservation.getUserd())
                        .hotel(reservation.getHotel())
                        .room(reservation.getRoom())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(reservationDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody reservationDto rDto) throws URISyntaxException {
        if (rDto.getEntry_date() == null ||
                rDto.getDate_out() == null ||
                rDto.getUserd() == null ||
                rDto.getHotel() == null ||
                rDto.getRoom() == null) {
            return ResponseEntity.badRequest().build();
        }

        // Asegurando que el Userd esté persistido
        Userd userd = uRepositoty.findById(rDto.getUserd()
        .getIduser())
        .orElseThrow(() -> new RuntimeException("User not found"));
        
        // Asegurando que el Hotel esté persistido
        Hotel hotel = hRepository.findById(rDto.getHotel()
        .getIdhotel())
        .orElseThrow(() -> new RuntimeException("Hotel not found"));
        
        // Asegurando que el Room esté persistido
        Room room = repository.findById(rDto.getRoom().getIdroom())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Reservation reservation = Reservation.builder()
                .entry_date(rDto.getEntry_date())
                .date_out(rDto.getDate_out())
                .userd(userd)
                .hotel(hotel)
                .room(room)
                .build();

        rService.save(reservation);

        return ResponseEntity.created(new URI("/api/reservation/save")).build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateReservation(@PathVariable Long id, @RequestBody reservationDto rDto) {
        Optional<Reservation> reOptional = rService.findById(id);

        if (reOptional.isPresent()) {
            Reservation reservation = reOptional.get();

            reservation.setEntry_date(rDto.getEntry_date());
            reservation.setDate_out(rDto.getDate_out());

            rService.save(reservation);
            return ResponseEntity.ok("Register update");

        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id) {
        Optional<Reservation> reOptional = rService.findById(id);
        if (reOptional.isPresent()) {
            rService.deleteById(id);
            return ResponseEntity.ok("Register delete");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The reservation with the ID " + id + " not found in the database.");
    }
}
