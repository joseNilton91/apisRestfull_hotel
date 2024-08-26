package com.apisRestfull.apisRestfull_hotel.models;

import java.math.BigDecimal;

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
@Table(name = "room")

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idroom")
    private long idroom;

    @Column(name = "Room_Number")
    private String room_number;

    @Column(name = "Room_Type")
    private String room_type;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Status_room")
    private String status_room;
    
    @ManyToOne
    @JoinColumn(name = "idhotel", referencedColumnName = "idhotel")
    private Hotel hotel;

}
