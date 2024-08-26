package com.apisRestfull.apisRestfull_hotel.persistence;

import java.util.List;
import java.util.Optional;

import com.apisRestfull.apisRestfull_hotel.models.Userd;

public interface IuserDto {

    Optional<Userd> findById(long id);

    List<Userd> findAll();

    String save(Userd userd);

    void deleteById(long id);

}
