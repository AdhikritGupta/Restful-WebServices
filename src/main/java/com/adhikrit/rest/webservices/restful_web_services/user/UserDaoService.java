package com.adhikrit.rest.webservices.restful_web_services.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
//	JPA/Hibernate > Database
//	UserDaoService > Static List
	private static List<User> users = new ArrayList<>();
	private static int num;
	static {
		users.add(new User(++num, "Adam", LocalDate.now().minusYears(30)));
		users.add(new User(++num, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++num, "Jim", LocalDate.now().minusYears(20)));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findById(int id) {
//		for (User user : users) {
//			if (user.getId()==id) {
//				return user;
//			}
//		}
//		return null;
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	
	public User save(User user) {
		user.setId(++num);
		users.add(user);
		return user;
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id); 
		users.removeIf(predicate);
	}
	
}
