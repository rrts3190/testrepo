package com.cwr.hotel.services.impl;

import com.cwr.hotel.entities.Hotel;
import com.cwr.hotel.exception.ResourceNotFoundException;
import com.cwr.hotel.repositories.HotelRepository;
import com.cwr.hotel.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        hotel.setId(UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll()
    {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getById(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("This hotel not found Id : " + id));
    }
}
