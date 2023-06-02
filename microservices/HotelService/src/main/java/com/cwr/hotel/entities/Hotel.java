package com.cwr.hotel.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "hotels")
public class Hotel
{
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}
