package com.apisRestfull.apisRestfull_hotel.repository;

import org.springframework.data.repository.CrudRepository;

import com.apisRestfull.apisRestfull_hotel.models.Reservation;

public interface reservationRepository  extends CrudRepository<Reservation, Long> {
    
}
