package com.project.authorization;





import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.authorization.model.MyUser;
import com.project.authorization.repository.MyUserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AuthorizationServiceApplication {
	@Autowired
	private MyUserRepository repository;
	
	 @PostConstruct
	    public void initUsers() {
	        List<MyUser> users = Stream.of(
	                new MyUser("dharani", "dharani@27", "dharani@gmail.com"),
	                new MyUser("swetha", "swetha", "swetha@gmail.com"),
	                new MyUser("prakash", "prakash", "prakash@gmail.com"),
	                new MyUser("selva", "selva", "selva@gmail.com")
	        ).collect(Collectors.toList());
	        repository.saveAll(users);
	    }

	public static void main(String[] args) {
		log.debug("START");
		SpringApplication.run(AuthorizationServiceApplication.class, args);
		log.debug("END");
	}
	

}
