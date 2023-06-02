package com.cwr.rating.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document("user_ratings")
public class Rating
{
    @Id
    private String ratingId;
    private String userId;
    private String hotelId;
    private String feedBack;
    private int rating;
}
