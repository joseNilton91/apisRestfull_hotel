package com.apisRestfull.apisRestfull_hotel.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "userd")

public class Userd {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "iduser")
    private long iduser;

    @Column(name = "Name_user")
    private String name_user;

    @Column(name = "Last_name")
    private String last_name;

    @Column(name = "Adress_user")
    private String adress_user;

    @Column(name = "Numberphone")
    private String numberphone;

    @Column(name = "Email")
    private String email;

}
