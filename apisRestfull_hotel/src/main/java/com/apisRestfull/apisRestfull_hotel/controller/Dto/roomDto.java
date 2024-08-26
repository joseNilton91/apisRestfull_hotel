package com.apisRestfull.apisRestfull_hotel.controller.Dto;

import java.math.BigDecimal;

import com.apisRestfull.apisRestfull_hotel.models.Hotel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class roomDto {

    private long idroom;

    private String room_number;

    private String room_type;

    private BigDecimal price;

    private String status_room;

    private Hotel hotel;

}
