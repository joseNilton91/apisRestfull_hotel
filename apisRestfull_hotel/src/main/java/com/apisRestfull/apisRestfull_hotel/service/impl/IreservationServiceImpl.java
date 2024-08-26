package com.apisRestfull.apisRestfull_hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apisRestfull.apisRestfull_hotel.models.Reservation;
import com.apisRestfull.apisRestfull_hotel.repository.reservationRepository;
import com.apisRestfull.apisRestfull_hotel.service.IreservationService;

@Service
public class IreservationServiceImpl implements IreservationService {

    @Autowired
    private reservationRepository repository;

    @Override
    public Optional<Reservation> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) repository.findAll();
    }

    @Override
    public String save(Reservation reservation) {
        repository.save(reservation);
        return "Success";
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

}
