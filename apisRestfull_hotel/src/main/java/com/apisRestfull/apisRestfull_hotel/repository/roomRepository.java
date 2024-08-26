package com.apisRestfull.apisRestfull_hotel.repository;

import org.springframework.data.repository.CrudRepository;

import com.apisRestfull.apisRestfull_hotel.models.Room;

public interface roomRepository extends CrudRepository <Room, Long> {
    
}
