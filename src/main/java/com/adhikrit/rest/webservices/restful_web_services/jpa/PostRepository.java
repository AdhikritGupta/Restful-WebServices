package com.adhikrit.rest.webservices.restful_web_services.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adhikrit.rest.webservices.restful_web_services.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	
}
