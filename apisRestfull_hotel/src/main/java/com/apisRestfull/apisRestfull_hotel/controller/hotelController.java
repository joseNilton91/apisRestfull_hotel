package com.apisRestfull.apisRestfull_hotel.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apisRestfull.apisRestfull_hotel.controller.Dto.hotelDto;
import com.apisRestfull.apisRestfull_hotel.models.Hotel;
import com.apisRestfull.apisRestfull_hotel.service.IhotelService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/hotel")

public class hotelController {

    @Autowired
    private IhotelService iService;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) { /// search for id

        Optional<Hotel> hotelOptional = iService.findById(id);
        if (hotelOptional.isPresent()) {

            Hotel hotel = hotelOptional.get();

            hotelDto hDto = hotelDto.builder()
                    .idhotel(hotel.getIdhotel())
                    .nameHotel(hotel.getNameHotel())
                    .adressHotel(hotel.getAdressHotel())
                    .numberPhone(hotel.getNumberPhone())
                    .build();

            return ResponseEntity.ok(hDto);

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The hotel with the ID " + id + " not found in the database.");
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<hotelDto>> findAll() {

        List<hotelDto> hotelDtoList = iService.findAll()
                .stream()
                .map(hotel -> hotelDto.builder()
                        .idhotel(hotel.getIdhotel())
                        .nameHotel(hotel.getNameHotel())
                        .adressHotel(hotel.getAdressHotel())
                        .numberPhone(hotel.getNumberPhone())
                        .build())

                .collect(Collectors.toList());

        return ResponseEntity.ok(hotelDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody hotelDto hDto) throws URISyntaxException {
        if (hDto.getNameHotel().isBlank() ||
                hDto.getAdressHotel().isBlank() ||
                hDto.getNumberPhone() == null ||
                hDto.getNumberPhone().isBlank()) {
            return ResponseEntity.ok("Register add");
        }

        iService.save(Hotel.builder()
                .nameHotel(hDto.getNameHotel())
                .adressHotel(hDto.getAdressHotel())
                .numberPhone(hDto.getNumberPhone())
                .build());

        return ResponseEntity.created(new URI("/api/hotel/save")).build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable Long id, @RequestBody hotelDto hDto) {
        Optional<Hotel> hOptional = iService.findById(id);

        if (hOptional.isPresent()) {
            Hotel hotel = hOptional.get();
            hotel.setNameHotel(hDto.getNameHotel());
            hotel.setAdressHotel(hDto.getAdressHotel());
            hotel.setNumberPhone(hDto.getNumberPhone());
            iService.save(hotel);
            return ResponseEntity.ok("Register update");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Hotel> hotel = iService.findById(id);
        if (hotel .isPresent()) {
            iService.deleteById(id);
            return ResponseEntity.ok("Register delete");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body("The hotel with the ID " + id + " not found in the database.");
        }
    }

}
