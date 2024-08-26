package com.apisRestfull.apisRestfull_hotel.service;

import java.util.List;
import java.util.Optional;

import com.apisRestfull.apisRestfull_hotel.models.Reservation;

public interface IreservationService {

    Optional<Reservation> findById(long id);

    List<Reservation> findAll();

    String save(Reservation reservation);

    void deleteById(long id);

}