package com.adhikrit.rest.webservices.restful_web_services;

import com.adhikrit.rest.webservices.restful_web_services.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Post {

	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	@Size(min = 10)
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "Post [id=" + id + ", description=" + description + "]";
	}
}
