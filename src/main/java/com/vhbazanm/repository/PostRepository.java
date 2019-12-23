package com.vhbazanm.repository;

import com.vhbazanm.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface PostRepository extends ElasticsearchRepository<Post, String> {

    Page<Post> findAll();



    Page<Post> findByTitle(String title, Pageable pageable);


}
