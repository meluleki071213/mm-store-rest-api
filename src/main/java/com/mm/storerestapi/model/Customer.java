package com.mm.storerestapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data //Lombok: Getter, Setter, ToString, Constructor
@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // specifies the generation strategies for the values of primary keys
    private long id;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Date_Of_Birth")
    private LocalDate dob;

    @Column(name = "Address")
    private String address; //This can be an object

    private LocalDate createdAt;
}
