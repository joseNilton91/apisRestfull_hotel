package com.apisRestfull.apisRestfull_hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apisRestfull.apisRestfull_hotel.models.Room;
import com.apisRestfull.apisRestfull_hotel.repository.roomRepository;
import com.apisRestfull.apisRestfull_hotel.service.IroomService;

@Service
public class IroomServiceImpl implements IroomService {

    @Autowired
    private roomRepository repository;

    @Override
    public Optional<Room> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Room> findAll() {
        return (List<Room>) repository.findAll();
    }

    @Override
    public String save(Room room) {
        repository.save(room);
        return "Success";
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

}
