package com.apisRestfull.apisRestfull_hotel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.apisRestfull.apisRestfull_hotel.models.Hotel;

@Repository
public interface hotelRepository extends CrudRepository <Hotel, Long> {
    
}
