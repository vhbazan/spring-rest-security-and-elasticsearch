package com.vhbazanm.controller;

import com.vhbazanm.constant.Constants;
import com.vhbazanm.exception.PostNotFoundException;
import com.vhbazanm.model.Post;
import com.vhbazanm.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = Constants.POST_API_BASE_PATH)
public class PostController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PostController.class);
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    PostService postService;

    /*@RequestMapping(value = "post", method = RequestMethod.POST)
    public Post post() {
        String[] tags = {"health", "life"};
        return new Post("abc", "first post", "description of the post", tags, "vhbazanm", new Date());
    }*/

    @GetMapping(path = "", produces = "application/json")
    public Iterable<Post> getAll(@RequestParam(value = "pageNumber", required = false) String pageNumber,
                                 @RequestParam(value = "pageSize", required = false) String pageSize) {
        LOGGER.debug("Processing GET request at {}", "");
        System.out.println("get Post, " + pageNumber + " and " + pageSize);
        Pageable pageable = createPageable(pageNumber !=null ? pageNumber: "0", pageSize !=null ? pageSize: "10");
        return postService.findAll();
    }

    @PostMapping(path = "")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        System.out.println("post Post: " + post);
        return new ResponseEntity<>(postService.save(post), HttpStatus.OK );
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Post> delete(@PathVariable("id") String id)  {
        Post tempPost = postService.findById(id);
        if(tempPost == null)  {
            System.out.println("Post " + id + " Not Found ");
            throw new PostNotFoundException();
        }
        else {
            System.out.println("DELETE Post, " + id );
            postService.deleteById(id);
            return new ResponseEntity<Post>( tempPost, HttpStatus.OK);
        }
    }

    private Pageable createPageable(String pageNumber, String pageSize) {
        return PageRequest.of(Integer.parseInt(pageNumber), Integer.parseInt(pageSize), Sort.by("createdAt"));
    }
}


