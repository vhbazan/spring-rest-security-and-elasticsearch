package com.vhbazanm.controller;

import com.vhbazanm.model.Post;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PostController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/post")
    public Post post() {
        String[] tags = {"health", "life"};
        return new Post("abc", "first post", "description of the post", tags, "vhbazanm", new Date());
    }

}


