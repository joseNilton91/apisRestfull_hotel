package com.apisRestfull.apisRestfull_hotel.models;

import java.time.LocalDate;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comment")

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idcomment")
    private long idcomment;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "Date_comment")
    private LocalDate date_comment;

    @Column(name = "Rating")
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    private Userd userd;

    @ManyToOne
    @JoinColumn(name = "idhotel", referencedColumnName = "idhotel")
    private Hotel hotel;
}
