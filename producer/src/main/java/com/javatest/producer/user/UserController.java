package com.javatest.producer.user;

import com.javatest.producer.service.PublisherService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
public class UserController  {

    private final PublisherService<User> publisherService;

    public UserController(@Qualifier("user-publisher") final PublisherService<User> publisherService) {
        this.publisherService = publisherService;
    }

    @PostMapping
    public void publishUser(@RequestBody User message) {
        publisherService.publish(message);
    }
}
