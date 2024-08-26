package com.apisRestfull.apisRestfull_hotel.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apisRestfull.apisRestfull_hotel.models.Reservation;
import com.apisRestfull.apisRestfull_hotel.persistence.IreservationDto;
import com.apisRestfull.apisRestfull_hotel.repository.reservationRepository;

@Component
public class IreservationDtoImpl implements IreservationDto {
    @Autowired
    private reservationRepository rRepository;

    @Override
    public Optional<Reservation> findById(long id) {
        return rRepository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return (List<Reservation>) rRepository.findAll();
    }

    @Override
    public String save(Reservation reservation) {
        rRepository.save(reservation);
        return "Success";
    }

    @Override
    public void deleteById(long id) {
        rRepository.deleteById(id);
    }

}
