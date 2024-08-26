package com.apisRestfull.apisRestfull_hotel.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apisRestfull.apisRestfull_hotel.models.Userd;
import com.apisRestfull.apisRestfull_hotel.persistence.IuserDto;
import com.apisRestfull.apisRestfull_hotel.repository.userdRepositoty;

@Component
public class IuserDtoImpl implements IuserDto {
    @Autowired
    private userdRepositoty uRepositoty;

    @Override
    public Optional<Userd> findById(long id) {
        return uRepositoty.findById(id);
    }

    @Override
    public List<Userd> findAll() {
        return (List<Userd>) uRepositoty.findAll();
    }

    @Override
    public String save(Userd userd) {
        uRepositoty.save(userd);
        return "Success";
    }

    @Override
    public void deleteById(long id) {
        uRepositoty.deleteById(id);
    }

}
