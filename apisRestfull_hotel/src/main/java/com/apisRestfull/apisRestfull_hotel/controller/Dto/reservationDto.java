package com.apisRestfull.apisRestfull_hotel.controller.Dto;

import java.time.LocalDate;

import com.apisRestfull.apisRestfull_hotel.models.Hotel;
import com.apisRestfull.apisRestfull_hotel.models.Room;
import com.apisRestfull.apisRestfull_hotel.models.Userd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class reservationDto {

    private long idreservation;

    private LocalDate entry_date;

    private LocalDate date_out;

    private Userd userd;

    private Hotel hotel;

    private Room room;
}
