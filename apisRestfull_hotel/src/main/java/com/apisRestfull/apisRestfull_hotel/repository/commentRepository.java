package com.apisRestfull.apisRestfull_hotel.repository;

import org.springframework.data.repository.CrudRepository;

import com.apisRestfull.apisRestfull_hotel.models.Comment;

public interface commentRepository extends CrudRepository<Comment, Long> {
    
}
