package com.apisRestfull.apisRestfull_hotel.persistence;

import java.util.List;
import java.util.Optional;

import com.apisRestfull.apisRestfull_hotel.models.Hotel;

public interface IhotelDAO {
    Optional <Hotel>findById(long id);

    List<Hotel> findAll();

    String save(Hotel hotel);

    void deleteById(long id);
}
