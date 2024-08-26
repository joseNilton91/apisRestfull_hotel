package com.apisRestfull.apisRestfull_hotel.service;

import java.util.List;
import java.util.Optional;

import com.apisRestfull.apisRestfull_hotel.models.Hotel;

public interface IhotelService {
    Optional<Hotel> findById(Long id);

    List<Hotel> findAll();

    String save(Hotel hotel);

    void deleteById(long id);

}
