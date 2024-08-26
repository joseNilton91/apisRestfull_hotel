package com.apisRestfull.apisRestfull_hotel.service;

import java.util.List;
import java.util.Optional;

import com.apisRestfull.apisRestfull_hotel.models.Userd;

public interface IuserService {
    Optional<Userd> findById(long id);

    List<Userd> findAll();

    String save(Userd userd);

    void deleteById(long id);
    
}
