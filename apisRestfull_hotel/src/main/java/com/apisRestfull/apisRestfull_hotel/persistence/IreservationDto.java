package com.apisRestfull.apisRestfull_hotel.persistence;

import java.util.List;
import java.util.Optional;

import com.apisRestfull.apisRestfull_hotel.models.Reservation;

public interface IreservationDto {
    Optional<Reservation> findById(long id);

    List<Reservation> findAll();

    String save(Reservation reservation);

    void deleteById(long id);
}
