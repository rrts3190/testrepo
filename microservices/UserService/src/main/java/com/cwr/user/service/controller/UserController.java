package com.cwr.user.service.controller;

import com.cwr.user.service.entities.User;
import com.cwr.user.service.services.UserService;;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
      return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }
    int retryCount = 1;
    @GetMapping("/{userId}")
   // @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBack")
   // @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallBack")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallBack")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId)
    {
        retryCount++;
        return ResponseEntity.ok(userService.getUser(userId));
    }


    public ResponseEntity<User> ratingHotelFallBack(String userId, Exception ex)
    {
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("This is dummy")
                .userId("dummy").build();
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<User>> getSingleUser()
    {
        return ResponseEntity.ok(userService.getAllUser());
    }
}
