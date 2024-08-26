package com.apisRestfull.apisRestfull_hotel.persistence;

import java.util.List;
import java.util.Optional;

import com.apisRestfull.apisRestfull_hotel.models.Room;

public interface IroomDto {

    Optional<Room> findById(long id);

    List<Room> findAll();

    String save(Room room);

    void deleteById(long id);
}
