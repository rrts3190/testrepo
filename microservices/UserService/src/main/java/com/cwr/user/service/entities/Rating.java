package com.cwr.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    private String userId;
    private String ratingId;
    private String hotelId;
    private String feedBack;
    private int rating;
    private Hotel hotel;
}
