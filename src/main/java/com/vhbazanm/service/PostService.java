package com.vhbazanm.service;

import com.vhbazanm.model.Post;
import org.springframework.data.domain.Page;

public interface PostService {

    public Post save(Post post);

    public Page<Post> findAll();
}
