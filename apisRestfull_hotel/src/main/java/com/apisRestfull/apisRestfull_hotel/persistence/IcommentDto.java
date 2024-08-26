package com.apisRestfull.apisRestfull_hotel.persistence;

import java.util.List;
import java.util.Optional;

import com.apisRestfull.apisRestfull_hotel.models.Comment;

public interface IcommentDto {
    Optional<Comment> findById(long id);

    List<Comment> findAll();

    String save(Comment comment);

    void deleteById(long id);
}
