package com.apisRestfull.apisRestfull_hotel.controller;

import org.springframework.web.bind.annotation.RestController;
import com.apisRestfull.apisRestfull_hotel.controller.Dto.userDto;
import com.apisRestfull.apisRestfull_hotel.models.Userd;
import com.apisRestfull.apisRestfull_hotel.service.IuserService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/userd")

public class userdController {

    @Autowired
    private IuserService iService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Userd> userOptional = iService.findById(id);

        if (userOptional.isPresent()) {

            Userd userd = userOptional.get();

            userDto uDto = userDto.builder()
                    .iduser(userd.getIduser())
                    .name_user(userd.getName_user())
                    .last_name(userd.getLast_name())
                    .adress_user(userd.getAdress_user())
                    .numberphone(userd.getNumberphone())
                    .email(userd.getEmail())
                    .build();

            return ResponseEntity.ok(uDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("The userd with the ID " + id + " not found in the database.");
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<userDto>> findAll() {

        List<userDto> optionalUserList = iService.findAll()
                .stream()
                .map(userd -> userDto.builder()
                .iduser(userd.getIduser())
                .name_user(userd.getName_user())
                .last_name(userd.getLast_name())
                .adress_user(userd.getAdress_user())
                .numberphone(userd.getNumberphone())
                .email(userd.getEmail())
                .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(optionalUserList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody userDto uDto) throws URISyntaxException {
        if (uDto.getName_user().isBlank() ||
                uDto.getLast_name().isBlank() ||
                uDto.getAdress_user().isBlank() ||
                uDto.getNumberphone() == null || // Check for null first
                uDto.getEmail().isBlank()) {

            return ResponseEntity.badRequest().build();

        }
        iService.save(Userd.builder()
                .name_user(uDto.getName_user())
                .last_name(uDto.getLast_name())
                .adress_user(uDto.getAdress_user())
                .numberphone(uDto.getNumberphone())
                .email(uDto.getEmail())
                .build());

        return ResponseEntity.created(new URI("api/userd/save")).build();
    }
    

     @PutMapping("/update/{id}")
    public ResponseEntity<?> updateHotel(@PathVariable Long id, @RequestBody userDto uDto) {
        Optional<Userd> uOptional = iService.findById(id);

        if (uOptional.isPresent()) {
            Userd userd = uOptional.get();
            userd.setName_user(uDto.getName_user());
            userd.setLast_name(uDto.getLast_name());
            userd.setAdress_user(uDto.getAdress_user());
            userd.setNumberphone(uDto.getNumberphone());
            userd.setEmail(uDto.getEmail());

            iService.save(userd);
            return ResponseEntity.ok("Register update");
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Userd> userd = iService.findById(id);
        if (userd.isPresent()) {
            iService.deleteById(id);
            return ResponseEntity.ok("Register delete");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The user with the ID " + id + " not found in the database.");
    }

}
