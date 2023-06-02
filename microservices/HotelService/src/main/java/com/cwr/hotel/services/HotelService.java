package com.cwr.hotel.services;


import com.cwr.hotel.entities.Hotel;

import java.util.List;

public interface HotelService {
   Hotel create (Hotel hotel);
   List<Hotel> getAll();
   Hotel getById(String id);

}
