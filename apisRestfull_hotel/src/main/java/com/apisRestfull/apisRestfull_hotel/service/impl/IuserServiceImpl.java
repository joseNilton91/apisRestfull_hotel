package com.apisRestfull.apisRestfull_hotel.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apisRestfull.apisRestfull_hotel.models.Userd;
import com.apisRestfull.apisRestfull_hotel.repository.userdRepositoty;
import com.apisRestfull.apisRestfull_hotel.service.IuserService;

@Service
public class IuserServiceImpl implements IuserService {

    @Autowired
    private userdRepositoty rUserdRepositoty;

    @Override
    public Optional<Userd> findById(long id) {
        return rUserdRepositoty.findById(id);
    }

    @Override
    public List<Userd> findAll() {
        return (List<Userd>) rUserdRepositoty.findAll();
    }

    @Override
    public String save(Userd userd) {
        rUserdRepositoty.save(userd);
        return "Success";
    }

    @Override
    public void deleteById(long id) {
        rUserdRepositoty.deleteById(id);
    }

}
