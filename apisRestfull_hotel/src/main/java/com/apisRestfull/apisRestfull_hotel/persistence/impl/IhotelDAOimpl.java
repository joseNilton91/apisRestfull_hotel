package com.apisRestfull.apisRestfull_hotel.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apisRestfull.apisRestfull_hotel.models.Hotel;
import com.apisRestfull.apisRestfull_hotel.persistence.IhotelDAO;
import com.apisRestfull.apisRestfull_hotel.repository.hotelRepository;

@Component
public class IhotelDAOimpl implements IhotelDAO {

    @Autowired
    private hotelRepository hRepository;

    @Override
    public Optional<Hotel> findById(long id) {
        return hRepository.findById(id);
    }

    @Override
    public List<Hotel> findAll() {
        return (List<Hotel>) hRepository.findAll();
    }

    @Override
    public String save(Hotel hotel) {
        hRepository.save(hotel);
        return "Success";
    }

    @Override
    public void deleteById(long id) {
        hRepository.deleteById(id);
    }

}
