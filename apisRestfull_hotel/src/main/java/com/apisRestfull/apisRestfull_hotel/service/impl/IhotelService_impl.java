package com.apisRestfull.apisRestfull_hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apisRestfull.apisRestfull_hotel.models.Hotel;
import com.apisRestfull.apisRestfull_hotel.persistence.IhotelDAO;
import com.apisRestfull.apisRestfull_hotel.service.IhotelService;

@Service
public class IhotelService_impl implements IhotelService {

    @Autowired
    private IhotelDAO ihotelDAO;

    @Override
    public Optional<Hotel> findById(Long id) {
        return ihotelDAO.findById(id);
    }

    @Override
    public List<Hotel> findAll() {
        return (List<Hotel>) ihotelDAO.findAll();
    }

    @Override
    public String save(Hotel hotel) {
        ihotelDAO.save(hotel);
        return "Success";
    }

    @Override
    public void deleteById(long id) {
        ihotelDAO.deleteById(id);
    }

}
