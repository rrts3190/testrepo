package com.cwr.rating.services;

import com.cwr.rating.entities.Rating;

import java.util.List;

public interface RatingService
{

    Rating create(Rating rating);
    List<Rating> getRatings();
    List<Rating> getRatingsByUserId(String userId);
    List<Rating> getRatingsByHotelId(String hotelId);
}
