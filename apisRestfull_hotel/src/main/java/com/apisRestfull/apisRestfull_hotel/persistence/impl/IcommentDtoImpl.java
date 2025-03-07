package com.apisRestfull.apisRestfull_hotel.persistence.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apisRestfull.apisRestfull_hotel.models.Comment;
import com.apisRestfull.apisRestfull_hotel.persistence.IcommentDto;
import com.apisRestfull.apisRestfull_hotel.repository.commentRepository;

@Component
public class IcommentDtoImpl implements IcommentDto {

    @Autowired
    private commentRepository cRepository;

    @Override
    public Optional<Comment> findById(long id) {
        return cRepository.findById(id);
    }

    @Override
    public List<Comment> findAll() {
        return (List<Comment>) cRepository.findAll();
    }

    @Override
    public String save(Comment comment) {
        cRepository.save(comment);
        return "Success";
    }

    @Override
    public void deleteById(long id) {
        cRepository.deleteById(id);
    }

}
