package com.apisRestfull.apisRestfull_hotel.controller.Dto;

import java.time.LocalDate;

import com.apisRestfull.apisRestfull_hotel.models.Hotel;
import com.apisRestfull.apisRestfull_hotel.models.Userd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class commentDto {

    private long idcomment;

    private String comment;

    private LocalDate date_comment;

    private Integer rating;

    private Userd userd;

    private Hotel hotel;

}
