package com.apisRestfull.apisRestfull_hotel.controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class hotelDto {

    private Long idhotel;

    private String nameHotel;

    private String adressHotel;

    private String numberPhone;

}
