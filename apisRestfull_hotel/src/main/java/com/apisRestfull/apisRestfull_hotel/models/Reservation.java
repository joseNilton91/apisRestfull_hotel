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
@Table(name = "reservation")

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idreservation")
    private long idreservation;

    @Column(name = "Entry_Date")
    private LocalDate entry_date;

    @Column(name = "Date_out")
    private LocalDate date_out;

    @ManyToOne
    @JoinColumn(name = "iduser", referencedColumnName = "iduser")
    private Userd userd;

    @ManyToOne
    @JoinColumn(name = "idhotel", referencedColumnName = "idhotel")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "idroom", referencedColumnName = "idroom")
    private Room room;

}
