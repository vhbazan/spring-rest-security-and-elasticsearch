package com.vhbazanm.controller;

import com.vhbazanm.model.Post;
import com.vhbazanm.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class PostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PostService postService;

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Post post() {
        String[] tags = {"health", "life"};
        return new Post("abc", "first post", "description of the post", tags, "vhbazanm", new Date());
    }

    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public Iterable<Post> getAll(@RequestParam(value = "pageNumber", required = false) String pageNumber,
                                 @RequestParam(value = "pageSize", required = false) String pageSize) {
        LOGGER.debug("Processing GET request at {}", "");
        System.out.println("get alerts, " + pageNumber + " and " + pageSize);
        Pageable pageable = createPageble(pageNumber !=null ? pageNumber: "0", pageSize !=null ? pageSize: "10");
        return postService.findAll();
    }
    private Pageable createPageble(String pageNumber, String pageSize) {
        return PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), Sort.by("createdAt"));
    }
}


