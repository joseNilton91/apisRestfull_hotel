package com.apisRestfull.apisRestfull_hotel.service;

import java.util.List;
import java.util.Optional;

import com.apisRestfull.apisRestfull_hotel.models.Room;

public interface IroomService {
    Optional<Room> findById(long id);

    List<Room> findAll();

    String save(Room room);

    void deleteById(long id);

}