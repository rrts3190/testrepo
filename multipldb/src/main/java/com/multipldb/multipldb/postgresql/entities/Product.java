package com.multipldb.multipldb.postgresql.entities;


import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "entities")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String description;
    private boolean live;
    private double price;

}
