package com.vhbazanm;

import com.vhbazanm.model.Post;
import com.vhbazanm.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class AppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}


	@Value("${es.post.indexname}")
	private String postIndexName = "";

	@Bean
	public String getPostIndexName() {
		return postIndexName;
	}


	@Autowired
	private PostService postService;

	@Override
	public void run(String... args) throws Exception {
		String[] tags = {"health", "life"};
		Post newPost = new Post("234", "My first Post", "Post details", tags, "vhbazanm", new Date());

		postService.save(newPost);

		System.out.println(postService.findAll());
	}



	private void printElasticSearchInfo() {

		System.out.println("--ElasticSearch-->");

		System.out.println("<--ElasticSearch--");
	}
}
