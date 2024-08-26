package com.apisRestfull.apisRestfull_hotel.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apisRestfull.apisRestfull_hotel.controller.Dto.commentDto;
import com.apisRestfull.apisRestfull_hotel.models.Comment;
import com.apisRestfull.apisRestfull_hotel.service.IcommentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/comment")

public class commentController {

    @Autowired
    private IcommentService cIcommentService;

    @GetMapping("{id}")
    public ResponseEntity<?> findById(@PathVariable long id) {
        Optional<Comment> optionalComment = cIcommentService.findById(id);

        if (optionalComment.isPresent()) {

            Comment comment = optionalComment.get();

            commentDto cDto = commentDto.builder()
                    .idcomment(comment.getIdcomment())
                    .comment(comment.getComment())
                    .date_comment(comment.getDate_comment())
                    .rating(comment.getRating())
                    .userd(comment.getUserd())
                    .hotel(comment.getHotel())
                    .build();

            return ResponseEntity.ok(cDto);

        }
        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<commentDto>> getMethodName() {

        List<commentDto> CommentDtoList = cIcommentService.findAll()
                .stream()
                .map(comment -> commentDto.builder()
                        .idcomment(comment.getIdcomment())
                        .comment(comment.getComment())
                        .date_comment(comment.getDate_comment())
                        .rating(comment.getRating())
                        .userd(comment.getUserd())
                        .hotel(comment.getHotel())
                        .build())
                .collect(Collectors.toList());
        return ResponseEntity.ok(CommentDtoList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody commentDto cDto) throws URISyntaxException {
        if (cDto.getComment().isBlank() ||
                cDto.getDate_comment() == null ||
                cDto.getRating() == null ||
                cDto.getUserd() == null ||
                cDto.getHotel() == null) {
            return ResponseEntity.badRequest().build();

        }

        cIcommentService.save(Comment.builder()
                .comment(cDto.getComment())
                .date_comment(cDto.getDate_comment())
                .rating(cDto.getRating())
                .userd(cDto.getUserd())
                .hotel(cDto.getHotel())
                .build());

        return ResponseEntity.created(new URI("/api/comment/save")).build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateComment(@PathVariable Long id, @RequestBody commentDto cDto) {
        Optional<Comment> optionalComment = cIcommentService.findById(id);

        if (optionalComment.isPresent()) {
            Comment comment = optionalComment.get();

            comment.setComment(cDto.getComment());
            comment.setDate_comment(cDto.getDate_comment());
            comment.setRating(cDto.getRating());

            cIcommentService.save(comment);

            return ResponseEntity.ok("Register update");

        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Comment> optionalComment = cIcommentService.findById(id);
        if (optionalComment.isPresent()) {
            cIcommentService.deleteById(id);
            return ResponseEntity.ok("Register delete");

        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("The comment with the ID " + id + " not found in the database.");
    }

}