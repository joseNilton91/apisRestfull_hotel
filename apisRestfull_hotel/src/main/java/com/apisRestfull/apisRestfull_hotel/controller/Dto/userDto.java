package com.apisRestfull.apisRestfull_hotel.controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class userDto {

    private long iduser;

    private String name_user;

    private String last_name;

    private String adress_user;

    private String numberphone;

    private String email;

}
