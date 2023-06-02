package com.cwr.user.service.services.impl;

import com.cwr.user.service.entities.Hotel;
import com.cwr.user.service.entities.Rating;
import com.cwr.user.service.entities.User;
import com.cwr.user.service.exception.ResourceNotFoundException;
import com.cwr.user.service.external.services.HotelService;
import com.cwr.user.service.repositories.UserRepository;
import com.cwr.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String id = UUID.randomUUID().toString();
        user.setUserId(id);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User No found userId" + userId));
        String url = "http://RATING-SERVICE/ratings/users/" + user.getUserId();
        ResponseEntity<Rating[]> ratingOfUsers = restTemplate.getForEntity(url, Rating[].class);
        List<Rating> myRatingList = Arrays.asList(ratingOfUsers.getBody());
        List<Rating> ratingList = myRatingList.stream()
                .map(rating -> {
                    rating.setHotel(hotelService.getHotel(rating.getHotelId()));
                    return rating;
                })
                .collect(Collectors.toList());
        logger.info("{}",ratingOfUsers);
        user.setRatings(ratingList);
        return user;
    }
}
